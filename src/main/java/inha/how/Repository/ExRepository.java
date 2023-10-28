package inha.how.Repository;

import inha.how.Domain.entity.Excersise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExRepository extends JpaRepository<Excersise, Long> {
    Excersise findExcersiseById(Long id);
}
