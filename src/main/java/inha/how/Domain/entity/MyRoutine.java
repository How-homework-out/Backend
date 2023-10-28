package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "my_routine")
@Getter
@Entity
public class MyRoutine {
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
