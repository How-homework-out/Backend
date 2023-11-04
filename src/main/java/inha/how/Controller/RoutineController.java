package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutineMeDetailMapping;
import inha.how.Domain.dto.routine.RoutineMeSaveReq;
import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Domain.entity.MyRoutine;
import inha.how.Domain.entity.Routine;
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

        allRoutineRes res = routineService.findRountines();

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
        User user = userService.validUser(jws);

        List<RoutineMeDetailMapping> res=routineService.findMyRoutine(user, type);

        return new BaseResponse<>(res);
    }

    @PostMapping("/me")
    public BaseResponse RoutineMeSave(@RequestHeader("Authorization") String jws, @RequestBody RoutineMeSaveReq req){
        User user = userService.validUser(jws);
        routineService.saveMyRoutine(user, req.getRoutId());

        return new BaseResponse();
    }
}
