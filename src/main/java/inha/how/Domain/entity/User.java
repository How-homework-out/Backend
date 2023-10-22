package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String userId;
    @Column(length = 15, nullable = false)
    private String nick;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(length = 30, nullable = false)
    private String email;
    @CreatedDate
    private LocalDateTime createDate;


}
