package inha.how.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.Excercise.ImgUrlMapping;
import inha.how.Domain.dto.live.ParticipateNicksMapping;
import inha.how.Domain.dto.live.liveExRes;
import inha.how.Domain.dto.live.liveRoutRes;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutinneDetailResult;
import inha.how.Domain.entity.Excersise;
import inha.how.Domain.entity.LiveRoom;
import inha.how.Repository.Live.LiveRepository;
import inha.how.Repository.Live.LiveRoutine;
import inha.how.Repository.Live.ParticipateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@RequiredArgsConstructor
@Service
public class StompService {

    private final LiveRoutine liveRoutine;
    private final LiveRepository liveRepository;
    private final ParticipateRepository participateRepository;


    public liveRoutRes modifyRoutine(Long roomId, Map<String, Object> data){
        Long routId=((Number) data.get("routId")).longValue();
        String name=(String) data.get("name");
        Integer hits=(Integer) data.get("hits");
        Long actionCnt=((Number) data.get("actionCnt")).longValue();

        List<Map<String, Object>> object = (List<Map<String, Object>>) data.get("routineDetails");
        List<RoutinneDetailResult> routinneDetailResultList=new ArrayList<>();

        ObjectMapper mapper=new ObjectMapper();

        object.forEach((obj)->{

            if (((Number) obj.get("type")).longValue() == 0L) {
                routinneDetailResultList.add(new RoutinneDetailResult(
                        ((Number) obj.get("id")).longValue(),
                        mapper.convertValue(obj.get("ex"), Excersise.class),
                        ((Number) obj.get("type")).longValue(),
                        ((Number) obj.get("set")).longValue(),
                        null,
                        ((Number) obj.get("count")).longValue(),
                        ((Number) obj.get("rest")).longValue(),
                        ((Number) obj.get("order")).longValue(),
                        (List<ImgUrlMapping>) obj.get("img"),
                        (List<CateInfoMapping>) obj.get("cate")));
            }
            else{
                routinneDetailResultList.add(new RoutinneDetailResult(
                        ((Number) obj.get("id")).longValue(),
                        mapper.convertValue(obj.get("ex"), Excersise.class),
                        ((Number) obj.get("type")).longValue(),
                        ((Number) obj.get("set")).longValue(),
                        ((Number) obj.get("time")).longValue(),
                        null,
                        ((Number) obj.get("rest")).longValue(),
                        ((Number) obj.get("order")).longValue(),
                        (List<ImgUrlMapping>) obj.get("img"),
                        (List<CateInfoMapping>) obj.get("cate")));
            }
        });

        Set<String> cate= new HashSet<>((Collection) data.get("cate"));
        liveRoutRes liveRoutRes=new liveRoutRes(routId, name, hits,actionCnt, cate, routinneDetailResultList);

        liveRoutRes modifiedRoutine = liveRoutine.modifyRoutine(roomId, liveRoutRes);

        return modifiedRoutine;
    }

    public List<ParticipateNicksMapping> findNicks(Long roomId){
        LiveRoom liveRoom=liveRepository.findLiveRoomById(roomId);
        List<ParticipateNicksMapping> nicks = participateRepository.findParticipateByParticipateIdLiveRoomOrderByCreateDateAsc(liveRoom);

        return nicks;
    }

}
