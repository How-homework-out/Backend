package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.calendar.CalendarAddRes;
import inha.how.Domain.dto.calendar.CalendarInfoMapping;
import inha.how.Domain.dto.calendar.CalendarModifyReq;
import inha.how.Domain.entity.User;
import inha.how.Service.CalendarService;
import inha.how.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/calendars")
@RequiredArgsConstructor
@RestController
public class CalendarController {

    private final UserService userService;
    private final CalendarService calendarService;

    @Operation(summary = "내 달력 조회", description = "자신의 달력을 조회하는 api다.")
    @GetMapping("")
    public BaseResponse<List<CalendarInfoMapping>> CalendarList(@RequestHeader("Authorization") String jws){
        User user = userService.validUser(jws);
        List<CalendarInfoMapping> res=calendarService.findCalendar(user);
        return new BaseResponse<>(res);
    }

    @Operation(summary = "내 달력 루틴 추가", description = "자신의 달력에 할 루틴을 등록하는 api다.")
    @PostMapping("")
    public BaseResponse CalendarAdd(@RequestHeader("Authorization") String jws, @RequestBody CalendarAddRes calendarAddRes){
        User user=userService.validUser(jws);
        calendarService.CalendarAdd(user, calendarAddRes);

        return new BaseResponse();
    }

    @Operation(summary = "달력 운동루틴 체크/해제", description = "내 달력의 할 운동 루틴에 체크/해제한다.")
    @PatchMapping("/{id}")
    public BaseResponse CalendarModify(@PathVariable("id") Long id, @RequestBody CalendarModifyReq calendarModifyReq){
        calendarService.modifyCalendar(id, calendarModifyReq);

        return new BaseResponse();
    }
}
