package inha.how.Domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100, nullable = false)
    private String url;

}
