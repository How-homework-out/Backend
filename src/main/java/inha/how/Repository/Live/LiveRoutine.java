package inha.how.Repository.Live;

import inha.how.Domain.dto.routine.RoutineDetailRes;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


public interface LiveRoutine {
    void save(Long id, RoutineDetailRes routineDetailRes);
    //수정
    RoutineDetailRes modifyRoutine(Long id, RoutineDetailRes routineDetailRes);
    void deleteRoutine();
    Object nextAction(Long id);
    RoutineDetailRes showRoutine(Long id);
}
