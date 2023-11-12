package inha.how.Repository.Live;

import inha.how.Domain.dto.live.ParticipateNicksMapping;
import inha.how.Domain.entity.Identify.ParticipateId;
import inha.how.Domain.entity.LiveRoom;
import inha.how.Domain.entity.Participate;
import inha.how.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipateRepository extends JpaRepository<Participate, Long> {
    Integer countByParticipateIdLiveRoom(LiveRoom live);
    List<ParticipateNicksMapping> findParticipateByParticipateIdLiveRoom(LiveRoom live);
    void deleteByParticipateId(ParticipateId participateId);
    void deleteByParticipateId_ParticipateAndParticipateId_LiveRoom(User participate, LiveRoom liveRoom);

}
