package inha.how.Repository;

import inha.how.Domain.dto.routine.RoutineMeDetailMapping;
import inha.how.Domain.entity.MyRoutine;
import inha.how.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRoutineReposiotry extends JpaRepository<MyRoutine, Long> {

    //최신순, 운동횟수

    List<RoutineMeDetailMapping> findMyRoutineByUserOrderByCreateTimeDesc(User user);

    List<RoutineMeDetailMapping> findMyRoutineByUserOrderByCountDesc(User user);


}
