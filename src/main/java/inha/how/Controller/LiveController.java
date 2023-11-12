package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.live.liveAddRes;
import inha.how.Domain.dto.live.liveListRes;
import inha.how.Domain.dto.live.liveParticipateReq;
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

    @Operation(summary = "live 등록", description = "방장이 live 방을 등록하는 api다.")
    @PostMapping("")
    public BaseResponse<liveAddRes> LiveAdd(@RequestHeader("Authorization") String jws, @RequestBody liveReq liveReq){
        User user = userService.validUser(jws);
        liveAddRes res = liveService.addLive(user, liveReq.getSubject(), liveReq.getRoutId());
        return new BaseResponse<>(res);
    }

    @Operation(summary = "live 종료(미완성)", description = "방장이 live를 삭제할 때 쓰는 api다.")
    @DeleteMapping("/{id}")
    public BaseResponse LiveLeave(@PathVariable("id") Long roomId){
        liveService.deleteLive(roomId);
        return new BaseResponse();
    }

    @Operation(summary = "live 참여하기", description = "참여자가 live를 참여할 때 쓰는 api다.")
    @PostMapping("/participates")
    public BaseResponse LiveParticipate(@RequestHeader("Authorization") String jws, @RequestBody liveParticipateReq req){
        User user = userService.validUser(jws);
        liveService.addParticipate(user, req.getLiveId());
        return new BaseResponse();
    }

    @Operation(summary = "live 나가기", description = "참여자가 live를 나갈 때 쓰는 api다.")
    @DeleteMapping("/participates/{id}")
    public BaseResponse LiveParticipateLeave(@RequestHeader("Authorization") String jws, @PathVariable("id") Long liveId){
        User user = userService.validUser(jws);
        liveService.deleteParticipate(user, liveId);
        return new BaseResponse();
    }


}
