package inha.how.Repository.Ex;

import inha.how.Domain.dto.Excercise.ExInfoMapping;
import inha.how.Domain.entity.Excersise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExRepository extends JpaRepository<Excersise, Long> {
    Excersise findExcersiseById(Long id);

}
