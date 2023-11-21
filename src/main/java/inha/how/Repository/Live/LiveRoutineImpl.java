package inha.how.Repository.Live;

import com.fasterxml.jackson.databind.ObjectMapper;
import inha.how.Domain.dto.live.liveExRes;
import inha.how.Domain.dto.live.liveRoutRes;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutinneDetailResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LiveRoutineImpl implements LiveRoutine{

    private final Map<Long, liveRoutRes> liveRoutine=new ConcurrentHashMap<>();
    private final Map<Long, Integer> nextAction = new ConcurrentHashMap<>();

    @Override
    public void save(Long id, liveRoutRes liveRoutRes) {
        liveRoutine.put(id, liveRoutRes);
        nextAction.put(id, 0);
    }

    @Override
    public liveRoutRes modifyRoutine(Long id, liveRoutRes liveRoutRes) {
        liveRoutine.put(id, liveRoutRes);

        return liveRoutine.get(id);
    }

    @Override
    public void deleteRoutine() {

    }

    @Override
    public Object nextAction(Long id) {
        Integer next = nextAction.get(id);
        nextAction.put(id, next+1);

        List<RoutinneDetailResult> detailResultList = liveRoutine.get(id).getRoutineDetails();

        RoutinneDetailResult detail=detailResultList.get(next);


        Long actionCnt=liveRoutine.get(id).getActionCnt();
        liveExRes liveExRes = new liveExRes(detail, actionCnt);

        return liveExRes;
    }

    @Override
    public liveRoutRes showRoutine(Long id){
        return liveRoutine.get(id);
    }
}
