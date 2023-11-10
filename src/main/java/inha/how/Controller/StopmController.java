package inha.how.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import inha.how.Domain.dto.live.ParticipateNicksMapping;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.entity.LiveRoom;
import inha.how.Repository.Live.LiveRepository;
import inha.how.Repository.Live.LiveRoutine;
import inha.how.Repository.Live.ParticipateRepository;
import inha.how.Service.LiveService;
import inha.how.Service.RoutineService;
import inha.how.Service.StompService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.fasterxml.jackson.core.JsonProcessingException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StopmController {

    private final LiveRoutine liveRoutine;
    private final LiveRepository liveRepository;
    private final ParticipateRepository participateRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final StompService stompService;



    @MessageMapping("/send")
    @SendTo
    public void sendMsg(@Payload Map<String,Object> data){

        int a=1;

        simpMessagingTemplate.convertAndSend("/topic/1", data);
    }

    @MessageMapping("/start/{roomId}")
    @SendTo
    public void sendStart(@Payload Map<String,Long> data, @DestinationVariable Long roomId){

        RoutineDetailRes routineDetailRes = liveRoutine.showRoutine(roomId);

        simpMessagingTemplate.convertAndSend("/room/routine/"+roomId, routineDetailRes);
    }

    @MessageMapping("/routine/{roomId}")
    @SendTo
    public void sendRoutine(@Payload Map<String, Object> data, @DestinationVariable Long roomId){

        RoutineDetailRes modifiedRoutine =stompService.modifyRoutine(roomId, data);

        simpMessagingTemplate.convertAndSend("/room/routine/"+roomId, modifiedRoutine);
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
        LiveRoom liveRoom= liveRepository.findLiveRoomById(roomId);
        Integer participate= participateRepository.countByParticipateIdLiveRoom(liveRoom);
        data.put("participate",participate);

        simpMessagingTemplate.convertAndSend("/room/participate/"+roomId, data);
    }

    @MessageMapping("/ex/{roomId}")
    @SendTo
    public void sendEx(@Payload Map<String, Object> data, @DestinationVariable Long roomId){

        Map<String, Object> ex = new ConcurrentHashMap<>();

        ex.put("ex", liveRoutine.nextAction(roomId));

        simpMessagingTemplate.convertAndSend("/room/ex/"+roomId, ex);
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

    @MessageMapping("/nick/{roomId}")
    @SendTo
    public void sendNick(@Payload Map<String, Object> data, @DestinationVariable Long roomId){
        List<ParticipateNicksMapping> res=stompService.findNicks(roomId);

        simpMessagingTemplate.convertAndSend("/room/nick/"+roomId, res);
    }



}
