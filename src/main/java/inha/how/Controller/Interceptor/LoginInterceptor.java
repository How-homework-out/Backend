package inha.how.Controller.Interceptor;

import inha.how.Config.exception.BaseException;
import inha.how.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inha.how.Config.BaseResponseStatus.*;
import static inha.how.Service.UserService.key;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    //private final UserRepository userRepository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
/*
        List<String> excludedCheckUrl=new ArrayList<String>();
        //excludedCheckUrl.add("/swagger/how");
        //excludedCheckUrl.add("/swagger/swagger-ui/index.html");
        //excludedCheckUrl.add("/swagger/swagger-ui/swagger-ui-standalone-preset.js");
        //excludedCheckUrl.add("/swagger/swagger-ui/swagger-ui-bundle.js");
        //excludedCheckUrl.add("/swagger/swagger-ui/swagger-initializer.js");
        //excludedCheckUrl.add("/v3/api-docs");
        //excludedCheckUrl.add("/v3/api-docs/swagger-config");
        excludedCheckUrl.add("/api/users/login");
        excludedCheckUrl.add("/api/live");
        excludedCheckUrl.add("/api/ex-routine/all");

        if(excludedCheckUrl.contains(request.getRequestURI())){
            //response.sendRedirect("/api/users/login");
            return false;
        }
*/
        log.error(request.getRequestURI());

        String jwt = request.getHeader("Authorization");

        if(jwt==null) throw new BaseException(EMPTY_JWT);

        Jws<Claims> jws;

        try{
            jws = Jwts.parser()
                    .verifyWith(key)
                    .build().parseClaimsJws(jwt);
        }
        catch (BaseException baseException){
            throw new BaseException(INVALID_JWT);
        }

        log.error(String.valueOf(jws));

/*
        User user = userRepository.findUserByUserIdAndPassword(jws, password);

        if(user==null){
            throw new BaseException(FAILED_TO_LOGIN);
        }


 */


        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
