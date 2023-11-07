package inha.how.Controller.Interceptor;

import inha.how.Config.exception.BaseException;
import inha.how.Domain.entity.User;
import inha.how.Repository.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import static inha.how.Config.BaseResponseStatus.*;
import static inha.how.Service.UserService.key;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        //preflight의 경우만 허용
        if(CorsUtils.isPreFlightRequest(request)){
            return true;
        }

        String jwt = request.getHeader("Authorization");

        if(jwt==null) throw new BaseException(EMPTY_JWT);

        String s=removeBear(jwt);
        log.error("jwt:"+s);

        Jws<Claims> jws;


        try{
            jws = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseClaimsJws(s);
            return true;
        }
        catch (ExpiredJwtException expiredJwtException){
            //만료된 토큰
            throw new BaseException(EXPIRED_JWT);
        }
        catch (MalformedJwtException malformedJwtException){
            //변조된 토큰
            throw new BaseException(MALFORMED_JWT);
        }
        catch (SignatureException signatureException){
            //잘못된 토큰
            throw new BaseException(INVALID_JWT);
        }
    }

    String removeBear(String jwt){
        if(jwt.contains("Bearer")){
            jwt=jwt.replace("Bearer ","");
        }
        return jwt;
    }
}
