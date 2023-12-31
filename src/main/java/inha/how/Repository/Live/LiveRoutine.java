package inha.how.Repository.Live;

import inha.how.Domain.dto.live.liveExRes;
import inha.how.Domain.dto.live.liveRoutRes;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


public interface LiveRoutine {
    void save(Long id, liveRoutRes liveRoutRes);
    liveRoutRes modifyRoutine(Long id, liveRoutRes liveRoutRes);
    Object nextAction(Long id);
    liveRoutRes showRoutine(Long id);
}
