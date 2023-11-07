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
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/ex-routines")
@RestController
public class RoutineController {

    private final RoutineService routineService;
    private final UserService userService;

    @Operation(summary = "운동 루틴 목록 조회", description = "운동 루틴 목록들을 조회하는 api다.")
    @GetMapping("")
    public BaseResponse<allRoutineRes> Routine(){

        //예외 처리 필요

        allRoutineRes res = routineService.findRountines();

        return new BaseResponse<>(res);
    }

    @Operation(summary = "운동 루틴 상세 조회", description = "특정 운동 루틴의 상세를 조회하는 api다.")
    @GetMapping("/{id}")
    public BaseResponse<RoutineDetailRes> RoutineDetails(@PathVariable("id") Long id){

        //예외 처리 필요

        RoutineDetailRes res = routineService.findRoutineOne(id);

        return new BaseResponse<>(res);
    }

    @Operation(summary = "내 운동 루틴 목록 조회", description = "내 운동 루틴 목록들을 조회하는 api다.")
    @GetMapping("/me")
    public BaseResponse<List<RoutineMeDetailMapping>> RoutineMeDetails(@RequestHeader("Authorization") String jws, @RequestParam boolean type){//<allRoutineRes>
        //예외 처리 필요
        User user = userService.validUser(jws);

        List<RoutineMeDetailMapping> res=routineService.findMyRoutine(user, type);

        return new BaseResponse<>(res);
    }

    @Operation(summary = "내 운동 루틴 등록", description = "운동 루틴을 내 운동 루틴으로 등록할 때 사용하는 api다.")
    @PostMapping("/me")
    public BaseResponse RoutineMeSave(@RequestHeader("Authorization") String jws, @RequestBody RoutineMeSaveReq req){
        User user = userService.validUser(jws);
        routineService.saveMyRoutine(user, req.getRoutId());

        return new BaseResponse();
    }
}
