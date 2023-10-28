package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "action_img")
@Getter
@Entity
public class ExImg {

    @Id
    @JoinColumn(name="action_id", referencedColumnName = "id")
    @ManyToOne
    Excersise exId;
    @Id
    @ManyToOne
    @JoinColumn(name = "img_id", referencedColumnName = "id")
    Image imgId;
}
