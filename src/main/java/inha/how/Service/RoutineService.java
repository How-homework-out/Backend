package inha.how.Service;

import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.routine.*;
import inha.how.Domain.entity.*;
import inha.how.Repository.*;
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
    private final MyRoutineReposiotry myRoutineReposiotry;
    private final ExRepository exRepository;
    private final ExCateRepository exCateRepository;

    public allRoutineRes findRountines(){
        List<Routine> routineList= routineRepository.findAllByOrderByHitsDesc();

        return new allRoutineRes(routineList);
    }

    public RoutineDetailRes findRoutineOne(Long id){
        Routine routine = routineRepository.findRoutineById(id);
        List<RoutineDetailMapping> routineDetails = routineDetailRepository.findRoutineDetailsByRoutineOrderByOrderAsc(routine);
        List<RoutinneDetailResult> routinneDetailResults = new ArrayList<>();
        
        //조회수 올라가는 거 필요

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

    //findMyRoutine
    public List<RoutineMeDetailMapping> findMyRoutine(User user, boolean type){
        //type 0일때, 최신순 1일 때, 운동횟수 별
        List<RoutineMeDetailMapping> meDetailMappingList;
        if(type){
            meDetailMappingList = myRoutineReposiotry.findMyRoutineByUserOrderByCreateTimeDesc(user);
        }
        else{
            meDetailMappingList = myRoutineReposiotry.findMyRoutineByUserOrderByCountDesc(user);
        }
        return meDetailMappingList;
    }

    public void saveMyRoutine(User user, Long id){
        //예외처리 필요

        Routine routine= routineRepository.findRoutineById(id);
        MyRoutine myRoutine = new MyRoutine();
        myRoutine.setUser(user);
        myRoutine.setRoutine(routine);
        myRoutine.setCount(0);

        myRoutineReposiotry.save(myRoutine);
    }


}
