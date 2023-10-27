package inha.how.Repository;

import inha.how.Domain.entity.Routine;
import inha.how.Domain.entity.RoutineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findAll();

    List<Routine> findAllByOrderByHitsDesc();

    Routine findRoutineById(Long id);


}
