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

    @MessageMapping("/start/{roomId}")
    @SendTo
    public void sendStart(@Payload Map<String,Long> data, @DestinationVariable Long roomId){

        RoutineDetailRes res = routineService.findRoutineOne(data.get("routId"));

        simpMessagingTemplate.convertAndSend("/room/routine/"+roomId, res);
    }

    @MessageMapping("/routine/{roodId}")
    @SendTo
    public void sendRoutine(@Payload Map<String, Object> data, @DestinationVariable Long roomId){
        //운동 수정 필요
        //운동 루틴 저장 필요
        RoutineDetailRes res = routineService.findRoutineOne((Long) data.get("routId"));


        simpMessagingTemplate.convertAndSend("/room/routine/"+roomId, res);
    }

    @MessageMapping("/participate/{roomId}")
    @SendTo
    public void sendParticipate(@Payload Map<String,Object> data, @DestinationVariable Long roomId){

        //동시성 문제 생길 수 있으므로 lock 하기
        //roomId에 해당하는 객체 불러오기
        //참여자 수 증가
        //DB에 save
        //lock 풀기
        //참여자 수 Map에 추가
        //정보 보내기

        simpMessagingTemplate.convertAndSend("/room/participate/"+roomId, data);
    }

    @MessageMapping("/leave/{roomId}")
    @SendTo
    public void sendLeave(@Payload Map<String, Object> data, @DestinationVariable Long roomId){
        simpMessagingTemplate.convertAndSend("/room/leave/"+roomId, data);
    }

    @MessageMapping("/ready/{roomId}")
    @SendTo
    public void sendReady(@Payload Map<String, Object> data, @DestinationVariable Long roomId){
        simpMessagingTemplate.convertAndSend("/room/ready/"+roomId, data);
    }

}
