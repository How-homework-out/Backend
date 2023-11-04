package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@NoArgsConstructor
@Table(name = "my_routine")
@Getter
@Setter
@Entity
public class MyRoutine extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "rout_id", referencedColumnName = "id")
    private Routine routine;
    private Integer count;

}
