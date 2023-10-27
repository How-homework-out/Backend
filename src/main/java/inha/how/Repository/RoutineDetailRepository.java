package inha.how.Repository;

import inha.how.Domain.entity.RoutineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineDetailRepository extends JpaRepository<RoutineDetails, Long> {
    RoutineDetails findRoutineDetailsById(Long id);


}
