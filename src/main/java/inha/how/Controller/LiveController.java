package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.live.liveListRes;
import inha.how.Domain.dto.live.liveReq;
import inha.how.Domain.entity.User;
import inha.how.Service.LiveService;
import inha.how.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/lives")
@RestController
public class LiveController {

    private final LiveService liveService;
    private final UserService userService;

    @Operation(summary = "live 목록 조회", description = "진행 중인 live 목록들을 조회하는 api다.")
    @GetMapping("")
    public BaseResponse<liveListRes> LiveProgressList(){
        liveListRes liveListRes = liveService.findLive();

        return new BaseResponse<>(liveListRes);
    }

    @Operation(summary = "live 등록", description = "live 방을 등록하는 api다.")
    @PostMapping("")
    public BaseResponse LiveAdd(@RequestHeader("Authorization") String jws, @RequestBody liveReq liveReq){
        User user = userService.validUser(jws);
        liveService.addLive(user, liveReq.getSubject(), liveReq.getRoutId());
        return new BaseResponse();
    }
    //LiveSearchList(search): 라이브 검색
    //api: /api/live/search POST
    //LiveLeave(roomId): 라이브 종료
    //api: /api/live/{id} GET
    @Operation(summary = "live 종료", description = "live를 삭제할 때 쓰는 api다.")
    @DeleteMapping("/{id}")
    public BaseResponse LiveLeave(@PathVariable("id") Long roomId){
        liveService.deleteLive(roomId);
        return new BaseResponse();
    }
}
