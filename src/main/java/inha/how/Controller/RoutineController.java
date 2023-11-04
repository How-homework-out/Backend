package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutineMeDetailMapping;
import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Domain.entity.User;
import inha.how.Service.RoutineService;
import inha.how.Service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/ex-routine")
@RestController
public class RoutineController {

    private final RoutineService routineService;
    private final UserService userService;

    @GetMapping("/all")
    public BaseResponse<allRoutineRes> Routine(){

        //예외 처리 필요

        allRoutineRes res = routineService.findRountine();

        return new BaseResponse<>(res);
    }

    @GetMapping("")
    public BaseResponse<RoutineDetailRes> RoutineDetails(@RequestParam Long id){

        //예외 처리 필요

        RoutineDetailRes res = routineService.findRoutineOne(id);

        return new BaseResponse<>(res);
    }

    @GetMapping("/me")
    public BaseResponse<List<RoutineMeDetailMapping>> RoutineMeDetails(@RequestHeader("Authorization") String jws, @RequestParam boolean type){//<allRoutineRes>
        //예외 처리 필요
        Jws<Claims> jwt= userService.jwtParse(jws);

        User user = userService.validUser(jwt.getPayload().get("userId").toString(), jwt.getPayload().get("password").toString());

        List<RoutineMeDetailMapping> res=routineService.findMyRoutine(user, type);

        return new BaseResponse<>(res);
    }

}
