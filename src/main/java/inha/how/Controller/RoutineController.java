package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Service.RoutineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/ex-routine")
@RestController
public class RoutineController {

    private final RoutineService routineService;

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
}
