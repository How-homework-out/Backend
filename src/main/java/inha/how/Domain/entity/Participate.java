package inha.how.Domain.entity;

import inha.how.Domain.entity.Identify.ParticipateId;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Participate {
    @EmbeddedId
    private ParticipateId participateId;
    @Embedded
    private Access access;
}
