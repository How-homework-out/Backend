package inha.how.Repository;

import inha.how.Domain.dto.routine.RoutineMeDetailMapping;
import inha.how.Domain.entity.MyRoutine;
import inha.how.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyRoutineReposiotry extends JpaRepository<MyRoutine, Long> {

    //최신순, 운동횟수

    List<RoutineMeDetailMapping> findMyRoutineByUserOrderByCreateTimeDesc(User user);

    List<RoutineMeDetailMapping> findMyRoutineByUserOrderByCountDesc(User user);
}
