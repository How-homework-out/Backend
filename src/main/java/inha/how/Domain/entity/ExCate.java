package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name="action_cate")
@Getter
@Entity
public class ExCate {
    @Id
    @ManyToOne
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    Excersise ex;
    @Id
    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    Category category;
}
