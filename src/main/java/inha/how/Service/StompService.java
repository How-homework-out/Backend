package inha.how.Service;

import inha.how.Domain.dto.live.ParticipateNicksMapping;
import inha.how.Domain.dto.live.liveExRes;
import inha.how.Domain.dto.live.liveRoutRes;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutinneDetailResult;
import inha.how.Domain.entity.LiveRoom;
import inha.how.Repository.Live.LiveRepository;
import inha.how.Repository.Live.LiveRoutine;
import inha.how.Repository.Live.ParticipateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Sets;

import java.util.*;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashSet;

@Slf4j
@RequiredArgsConstructor
@Service
public class StompService {

    private final LiveRoutine liveRoutine;
    private final LiveRepository liveRepository;
    private final ParticipateRepository participateRepository;

    public liveRoutRes modifyRoutine(Long roomId, Map<String, Object> data){
        log.error(String.valueOf(data));
        Long routId=((Number) data.get("routId")).longValue();
        String name=(String) data.get("name");
        Integer hits=(Integer) data.get("hits");
        Long actionCnt=((Number) data.get("actionCnt")).longValue();
        List<RoutinneDetailResult> routinneDetailResultList = (List<RoutinneDetailResult>) data.get("routineDetails");
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
