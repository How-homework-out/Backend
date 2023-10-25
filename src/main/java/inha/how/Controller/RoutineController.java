package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/ex-routine")
@RestController
public class RoutineController {

    private final RoutineService routineService;

    @GetMapping("/all")
    public BaseResponse<allRoutineRes> Routinie(){

        allRoutineRes res = routineService.findRountine();

        return new BaseResponse<>(res);
    }
}
