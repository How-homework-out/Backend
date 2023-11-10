package inha.how.Domain.entity;

import inha.how.Domain.entity.Identify.ParticipateId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Participate {
    @EmbeddedId
    private ParticipateId participateId;
    @Enumerated(EnumType.STRING)
    private Access access;
}
