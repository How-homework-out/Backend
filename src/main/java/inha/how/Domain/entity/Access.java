package inha.how.Domain.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Access {
    owner,participate;
}
