package inha.how.Domain.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRes {
    String jwt;
    String userId;
    String nick;
    String email;
}
