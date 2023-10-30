package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name="Action")
@Getter
@Entity
public class Excersise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String desc;
}
