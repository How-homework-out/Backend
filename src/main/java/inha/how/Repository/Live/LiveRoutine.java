package inha.how.Repository.Live;

import inha.how.Domain.dto.routine.RoutineDetailRes;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


public interface LiveRoutine {
    void save(Long id, RoutineDetailRes routineDetailRes);
    //수정
    void modifyRoutine();
    void deleteRoutine();
    Object nextAction(Long id);
}
