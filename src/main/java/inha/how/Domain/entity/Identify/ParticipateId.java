package inha.how.Domain.entity.Identify;

import inha.how.Domain.entity.LiveRoom;
import inha.how.Domain.entity.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ParticipateId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "live_id", referencedColumnName = "id")
    LiveRoom liveRoom;
    @ManyToOne
    @JoinColumn(name = "participate_id", referencedColumnName = "id")
    User participate;
}
