package inha.how.Service;

import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.routine.*;
import inha.how.Domain.entity.*;
import inha.how.Repository.Ex.ExCateRepository;
import inha.how.Repository.Ex.ExRepository;
import inha.how.Repository.Routine.MyRoutineReposiotry;
import inha.how.Repository.Routine.RoutineDetailRepository;
import inha.how.Repository.Routine.RoutineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final RoutineDetailRepository routineDetailRepository;
    private final MyRoutineReposiotry myRoutineReposiotry;
    private final ExRepository exRepository;
    private final ExCateRepository exCateRepository;

    public allRoutineRes findRountines(Boolean type){
        List<Routine> routineList;
        if(type){//최신순
            routineList= routineRepository.findAllByOrderByHitsDesc();
        }
        else{//조회순
            routineList= routineRepository.findAllByOrderByCreateDateDesc();
        }

        List<RoutinesResult> routinesResults=new ArrayList<>();

        routineList.forEach((routine)->{

            List<RoutineDetailMapping> routineDetails = routineDetailRepository.findRoutineDetailsByRoutineOrderByOrderAsc(routine);
            Set<String> cate=findRoutineCate(routineDetails);

/*
            RoutineDetailRes routineDetailRes=findRoutineOne(routine.getId());
            List<RoutinneDetailResult> routinneDetailResultList = routineDetailRes.getRoutineDetails();

            routinneDetailResultList.forEach((action)->{
                action.getCate().forEach((category)->{
                    cate.add(category.getExCateIdCategoryName());
                });
            });

 */


            RoutinesResult routinesResult=new RoutinesResult(routine, cate);
            routinesResults.add(routinesResult);
        });


        return new allRoutineRes(routinesResults);
    }

    public Set<String> findRoutineCate(List<RoutineDetailMapping> routineDetailMappingList){
        Set<String> cate=new HashSet<>();

        routineDetailMappingList.forEach((detail)->{
            List<CateInfoMapping> cateExInfo=findExCate(detail);

            cateExInfo.forEach((category)->{
                cate.add(category.getExCateIdCategoryName());
            });
        });

        return cate;
    }

    public  List<CateInfoMapping> findExCate(RoutineDetailMapping routineDetail){
        Long exId = routineDetail.getEx().getId();
        Excersise excersise = exRepository.findExcersiseById(exId);
        List<CateInfoMapping> excersiseList = exCateRepository.findExCateByExCateIdEx(excersise);

        return excersiseList;
    }

    public RoutineDetailRes findRoutineOne(Long id){
        Routine routine = findRoutineById(id);
        List<RoutineDetailMapping> routineDetails = routineDetailRepository.findRoutineDetailsByRoutineOrderByOrderAsc(routine);
        List<RoutinneDetailResult> routineDetailResults = new ArrayList<>();
        Set<String> cate=findRoutineCate(routineDetails);
        
        //조회수 올라가는 거 필요

        routineDetails.forEach((detail)->{
            //Long exId = detail.getEx().getId();
            //Excersise excersise = exRepository.findExcersiseById(exId);

            //이미지

            //운동 부위
            //List<CateInfoMapping> excersiseList = exCateRepository.findExCateByExCateIdEx(excersise);
            List<CateInfoMapping> excersiseList=findExCate(detail);

            routineDetailResults.add(new RoutinneDetailResult(detail.getId(), detail.getEx(), detail.getType(), detail.getSet(), detail.getTime(), detail.getCount(), detail.getRest(), detail.getOrder(), excersiseList));


        });

        return new RoutineDetailRes(routine.getId(), routine.getSubject(), routine.getHits(),cate, routineDetailResults);
    }

    //findMyRoutine
    public List<RoutineMeResult> findMyRoutine(User user, boolean type){
        //type 0일때, 최신순 1일 때, 운동횟수 별
        List<RoutineMeDetailMapping> meDetailMappingList;
        List<RoutineMeResult> res=new ArrayList<>();
        if(type){
            meDetailMappingList = myRoutineReposiotry.findMyRoutineByUserOrderByCreateDateDesc(user);
        }
        else{
            meDetailMappingList = myRoutineReposiotry.findMyRoutineByUserOrderByCountDesc(user);
        }

        meDetailMappingList.forEach((meRoutine)->{
            Routine routine = findRoutineById(meRoutine.getRoutineId());
            List<RoutineDetailMapping> routineDetails = routineDetailRepository.findRoutineDetailsByRoutineOrderByOrderAsc(routine);

            Set<String> cate = findRoutineCate(routineDetails);

            res.add(new RoutineMeResult(meRoutine, cate));
        });

        return res;
    }

    public void saveMyRoutine(User user, Long id){
        //예외처리 필요

        Routine routine= findRoutineById(id);
        MyRoutine myRoutine = new MyRoutine();
        myRoutine.setUser(user);
        myRoutine.setRoutine(routine);
        myRoutine.setCount(0);

        myRoutineReposiotry.save(myRoutine);
    }

    public Routine findRoutineById(Long id){
        Routine routine= routineRepository.findRoutineById(id);

        return routine;
    }

}
