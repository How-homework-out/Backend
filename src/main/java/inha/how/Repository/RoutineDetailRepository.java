package inha.how.Repository;

import inha.how.Domain.dto.routine.RoutineDetailMapping;
import inha.how.Domain.entity.Routine;
import inha.how.Domain.entity.RoutineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineDetailRepository extends JpaRepository<RoutineDetails, Long> {
    List<RoutineDetailMapping> findRoutineDetailsByRoutineOrderByOrderAsc(Routine routine);
}
