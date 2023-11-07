package inha.how.Service;

import inha.how.Config.exception.BaseException;
import inha.how.Domain.dto.users.LoginRes;
import inha.how.Domain.entity.User;
import inha.how.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;

import static inha.how.Config.BaseResponseStatus.FAILED_TO_LOGIN;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    //JWT 토큰 발급
    public static SecretKey key=Jwts.SIG.HS256.key().build();

    private final UserRepository userRepository;
    public LoginRes login(String userId, String password){

        User user = userRepository.findUserByUserIdAndPassword(userId, password);

        if(user==null){
            throw new BaseException(FAILED_TO_LOGIN);
        }

        String jwts = Jwts.builder()
                .subject("ryul")
                .claim("userId", user.getUserId())
                .claim("password", user.getPassword())
                .claim("nick", user.getNick())
                .claim("email", user.getPassword())
                .signWith(key).compact();

        return new LoginRes(jwts, user.getUserId(), user.getNick(), user.getEmail());
    }

    public User validUser(String jwt){
        Jws<Claims> jws = jwtParse(jwt);

        String userId = jws.getPayload().get("userId").toString();
        String password = jws.getPayload().get("password").toString();

        User user = userRepository.findUserByUserIdAndPassword(userId, password);

        if(user==null){
            throw new BaseException(FAILED_TO_LOGIN);
        }

        return user;
    }

    public Jws<Claims> jwtParse(String jwt){
        jwt = removeBear(jwt);

        Jws<Claims> jws=Jwts.parser()
                .requireSubject("ryul")
                .verifyWith(key)
                .build().parseClaimsJws(jwt);

        return jws;
    }

    String removeBear(String jwt){
        if(jwt.contains("Bearer")){
            jwt=jwt.replace("Bearer ","");
        }
        return jwt;
    }
}
