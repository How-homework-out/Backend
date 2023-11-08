package inha.how.Repository.Live;

import inha.how.Domain.entity.LiveRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveRepository extends JpaRepository<LiveRoom, Long> {
    List<LiveRoom> findAll();
}
