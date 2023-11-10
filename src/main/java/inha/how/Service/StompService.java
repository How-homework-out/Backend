package inha.how.Service;

import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutinneDetailResult;
import inha.how.Repository.Live.LiveRoutine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class StompService {

    private final LiveRoutine liveRoutine;

    public RoutineDetailRes modifyRoutine(Long roomId, Map<String, Object> data){
        Long routId=((Number) data.get("routId")).longValue();
        String name=(String) data.get("name");
        Integer hits=(Integer) data.get("hits");
        List<RoutinneDetailResult> routinneDetailResultList = (List<RoutinneDetailResult>) data.get("routineDetails");
        RoutineDetailRes detailRes=new RoutineDetailRes(routId, name, hits, routinneDetailResultList);

        RoutineDetailRes modifiedRoutine = liveRoutine.modifyRoutine(roomId, detailRes);

        return modifiedRoutine;
    }

}
