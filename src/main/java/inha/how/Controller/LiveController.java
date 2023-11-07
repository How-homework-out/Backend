package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.live.liveListRes;
import inha.how.Domain.dto.live.liveReq;
import inha.how.Domain.entity.User;
import inha.how.Service.LiveService;
import inha.how.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/live")
@RestController
public class LiveController {

    private final LiveService liveService;
    private final UserService userService;

    @GetMapping("")
    public BaseResponse<liveListRes> LiveProgressList(){
        liveListRes liveListRes = liveService.findLive();

        return new BaseResponse<>(liveListRes);
    }

    @PostMapping("")
    public BaseResponse LiveAdd(@RequestHeader("Authorization") String jws, @RequestBody liveReq liveReq){
        User user = userService.validUser(jws);
        liveService.addLive(user, liveReq.getSubject(), liveReq.getRoutId());
        return new BaseResponse();
    }
    //LiveSearchList(search): 라이브 검색
    //api: /api/live/search POST
    //LiveLeave(roomId): 라이브 종료
    //api: /api/live/leave?roomId=:id GET
}
