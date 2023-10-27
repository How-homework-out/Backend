package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class RoutineDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="act_id",referencedColumnName = "id")
    private Action action;
    @ManyToOne
    @JoinColumn(name="rout_id", referencedColumnName = "id")
    private Routine routine;
    private Long type;
    @Column(nullable = true)
    private Long count;
    private Long time;
    private Long rest;
    private Long set;
    private Long order;
}
