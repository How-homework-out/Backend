package inha.how.Service;

import inha.how.Domain.dto.live.ParticipateNicksMapping;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutinneDetailResult;
import inha.how.Domain.entity.LiveRoom;
import inha.how.Repository.Live.LiveRepository;
import inha.how.Repository.Live.LiveRoutine;
import inha.how.Repository.Live.ParticipateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StompService {

    private final LiveRoutine liveRoutine;
    private final LiveRepository liveRepository;
    private final ParticipateRepository participateRepository;

    public RoutineDetailRes modifyRoutine(Long roomId, Map<String, Object> data){
        Long routId=((Number) data.get("routId")).longValue();
        String name=(String) data.get("name");
        Integer hits=(Integer) data.get("hits");
        List<RoutinneDetailResult> routinneDetailResultList = (List<RoutinneDetailResult>) data.get("routineDetails");
        Set<String> cate=(Set<String>) data.get("cate");
        RoutineDetailRes detailRes=new RoutineDetailRes(routId, name, hits, cate, routinneDetailResultList);

        RoutineDetailRes modifiedRoutine = liveRoutine.modifyRoutine(roomId, detailRes);

        return modifiedRoutine;
    }

    public List<ParticipateNicksMapping> findNicks(Long roomId){
        LiveRoom liveRoom=liveRepository.findLiveRoomById(roomId);
        List<ParticipateNicksMapping> nicks = participateRepository.findParticipateByParticipateIdLiveRoom(liveRoom);

        return nicks;
    }

}
