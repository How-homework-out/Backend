package inha.how.Controller;

import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Service.RoutineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StopmController {

    private final RoutineService routineService;

    private final SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/send")
    @SendTo
    public void sendMsg(@Payload Map<String,Object> data){

        int a=1;

        simpMessagingTemplate.convertAndSend("/topic/1", data);
    }

    @MessageMapping("/routine/{roomId}")
    //@SubscribeMapping("/routine/{roomId}")
    @SendTo
    public void sendRoutine(@Payload Map<String,Long> data, @DestinationVariable Long roomId){

        RoutineDetailRes res = routineService.findRoutineOne(data.get("routId"));

        simpMessagingTemplate.convertAndSend("/room/routine/"+roomId, res);
    }
}
