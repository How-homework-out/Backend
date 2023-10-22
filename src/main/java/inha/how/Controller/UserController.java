package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Config.exception.BaseException;
import inha.how.Domain.dto.users.LoginReq;
import inha.how.Domain.dto.users.LoginRes;
import inha.how.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static inha.how.Config.BaseResponseStatus.USERS_EMPTY_PASSWORD;
import static inha.how.Config.BaseResponseStatus.USERS_EMPTY_USER_ID;

@Tag(name="User", description = "User API!!!!!!!")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Operation(summary = "login", description = "로그인할 때 쓰는 api다.")
    @PostMapping("/login")
    public BaseResponse<LoginRes> login(@RequestBody LoginReq loginReq){

        if(loginReq.getUserId()==null) throw new BaseException(USERS_EMPTY_USER_ID);
        if(loginReq.getPassword()==null) throw new BaseException(USERS_EMPTY_PASSWORD);

        LoginRes res = userService.login(loginReq.getUserId(), loginReq.getPassword());


        return new BaseResponse<>(res);
    }

}
