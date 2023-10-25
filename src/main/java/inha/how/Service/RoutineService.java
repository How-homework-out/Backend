package inha.how.Service;

import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Domain.entity.Routine;
import inha.how.Repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    public allRoutineRes findRountine(){
        List<Routine> routineList= routineRepository.findAllByOrderByHitsDesc();

        return new allRoutineRes(routineList);
    }

}
