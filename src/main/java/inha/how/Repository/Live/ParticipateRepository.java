package inha.how.Repository.Live;

import inha.how.Domain.entity.LiveRoom;
import inha.how.Domain.entity.Participate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipateRepository extends JpaRepository<Participate, Long> {
    Integer countByParticipateIdLiveRoom(LiveRoom live);
}
