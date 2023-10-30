package inha.how.Domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Participate {
    @Id
    @ManyToOne
    @JoinColumn(name = "live_id", referencedColumnName = "id")
    private LiveRoom liveRoom;
    @Id
    @ManyToOne
    @JoinColumn(name = "participate_id", referencedColumnName = "id")
    private User participate;
    private Access access;
}
