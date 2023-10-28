package inha.how.Service;

import inha.how.Domain.dto.routine.RoutineDetailMapping;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Domain.entity.Routine;
import inha.how.Domain.entity.RoutineDetails;
import inha.how.Repository.RoutineDetailRepository;
import inha.how.Repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final RoutineDetailRepository routineDetailRepository;

    public allRoutineRes findRountine(){
        List<Routine> routineList= routineRepository.findAllByOrderByHitsDesc();

        return new allRoutineRes(routineList);
    }

    public RoutineDetailRes findRoutineOne(Long id){
        Routine routine = routineRepository.findRoutineById(id);
        List<RoutineDetailMapping> routineDetails = routineDetailRepository.findRoutineDetailsByRoutineOrderByOrderAsc(routine);

        return new RoutineDetailRes(routine.getId(), routine.getSubject(), routine.getHits(),routineDetails);
    }

}
