package inha.how.Domain.entity.Identify;

import inha.how.Domain.entity.Excersise;
import inha.how.Domain.entity.Image;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ExImgId implements Serializable {
    @JoinColumn(name="action_id", referencedColumnName = "id")
    @ManyToOne
    Excersise ex;
    @ManyToOne
    @JoinColumn(name = "img_id", referencedColumnName = "id")
    Image img;
}
