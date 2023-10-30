package inha.how.Service;

import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.routine.RoutineDetailMapping;
import inha.how.Domain.dto.routine.RoutineDetailRes;
import inha.how.Domain.dto.routine.RoutinneDetailResult;
import inha.how.Domain.dto.routine.allRoutineRes;
import inha.how.Domain.entity.Excersise;
import inha.how.Domain.entity.Routine;
import inha.how.Domain.entity.RoutineDetails;
import inha.how.Repository.ExCateRepository;
import inha.how.Repository.ExRepository;
import inha.how.Repository.RoutineDetailRepository;
import inha.how.Repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final RoutineDetailRepository routineDetailRepository;
    private final ExRepository exRepository;
    private final ExCateRepository exCateRepository;

    public allRoutineRes findRountine(){
        List<Routine> routineList= routineRepository.findAllByOrderByHitsDesc();

        return new allRoutineRes(routineList);
    }

    public RoutineDetailRes findRoutineOne(Long id){
        Routine routine = routineRepository.findRoutineById(id);
        List<RoutineDetailMapping> routineDetails = routineDetailRepository.findRoutineDetailsByRoutineOrderByOrderAsc(routine);
        List<RoutinneDetailResult> routinneDetailResults = new ArrayList<>();

        routineDetails.forEach((detail)->{
            Long exId = detail.getEx().getId();
            Excersise excersise = exRepository.findExcersiseById(exId);

            //이미지

            //운동 부위
            List<CateInfoMapping> excersiseList = exCateRepository.findExCateByExCateIdEx(excersise);

            routinneDetailResults.add(new RoutinneDetailResult(detail.getId(), detail.getEx(), detail.getType(), detail.getSet(), detail.getTime(), detail.getCount(), detail.getRest(), detail.getOrder(), excersiseList));
        });



        return new RoutineDetailRes(routine.getId(), routine.getSubject(), routine.getHits(),routinneDetailResults);
    }



}
