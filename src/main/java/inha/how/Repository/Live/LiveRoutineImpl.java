package inha.how.Repository.Live;

import inha.how.Domain.dto.routine.RoutineDetailRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class LiveRoutineImpl implements LiveRoutine{

    private final Map<Long, RoutineDetailRes> liveRoutine=new ConcurrentHashMap<>();
    private final Map<Long, Integer> nextAction = new ConcurrentHashMap<>();

    @Override
    public void save(Long id, RoutineDetailRes routineDetailRes) {
        liveRoutine.put(id, routineDetailRes);
        nextAction.put(id, 0);
    }

    @Override
    public void modifyRoutine() {

    }

    @Override
    public void deleteRoutine() {

    }

    @Override
    public Object nextAction(Long id) {
        Integer next = nextAction.get(id);
        nextAction.put(id, next+1);

        return liveRoutine.get(id).getRoutineDetails().get(next);
    }
}
