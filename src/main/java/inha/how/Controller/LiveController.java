package inha.how.Controller;

import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.live.liveListRes;
import inha.how.Service.LiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/live")
@RestController
public class LiveController {

    private final LiveService liveService;

    @GetMapping("")
    public BaseResponse<liveListRes> LiveProgressList(){
        liveListRes liveListRes = liveService.findLive();

        return new BaseResponse<>(liveListRes);
    }

    //LiveSearchList(search): 라이브 검색
    //api: /api/live/search POST
    //LiveLeave(roomId): 라이브 종료
    //api: /api/live/leave?roomId=:id GET
}
