package inha.how.Repository.Routine;

import inha.how.Domain.entity.Routine;
import inha.how.Domain.entity.RoutineDetails;
import inha.how.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findAll();

    List<Routine> findAllByOrderByHitsDesc();
    List<Routine> findAllByOrderByCreateDateDesc();

    Routine findRoutineById(Long id);

    //List<Routine> findRoutineByUserOrderByCreateDateCreateDateDesc(User user);
    //List<Routine> findRoutineByUserOrderByCreateDateCreateDateDesc(User user);
}
