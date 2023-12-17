package inha.how.Repository.Routine;

import inha.how.Domain.dto.routine.RoutineMeDetailMapping;
import inha.how.Domain.entity.MyRoutine;
import inha.how.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRoutineReposiotry extends JpaRepository<MyRoutine, Long> {

    List<RoutineMeDetailMapping> findMyRoutineByUserOrderByCreateDateDesc(User user);

    List<RoutineMeDetailMapping> findMyRoutineByUserOrderByCountDesc(User user);


}
