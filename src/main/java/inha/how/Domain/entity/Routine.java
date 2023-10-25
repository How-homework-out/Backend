package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String subject;
    @Column(nullable = false)
    private Integer hits;
    @CreatedDate
    private LocalDateTime createDate;
}
