package inha.how.Service;

import inha.how.Config.exception.BaseException;
import inha.how.Domain.dto.users.LoginRes;
import inha.how.Domain.entity.User;
import inha.how.Repository.UserRepository;
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

    private final UserRepository userRepository;
    public LoginRes login(String userId, String password){

        User user = userRepository.findUserByUserIdAndPassword(userId, password);

        if(user==null){
            throw new BaseException(FAILED_TO_LOGIN);
        }

        //JWT 토큰 발급
        SecretKey key=Jwts.SIG.HS256.key().build();

        String jwts = Jwts.builder()
                .subject("ryul")
                .claim("userId", user.getUserId())
                .claim("nick", user.getNick())
                .claim("email", user.getPassword())
                .signWith(key).compact();

        return new LoginRes(jwts, user.getUserId(), user.getNick(), user.getEmail());
    }




}
