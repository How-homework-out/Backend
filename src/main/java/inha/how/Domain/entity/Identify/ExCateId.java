package inha.how.Domain.entity.Identify;

import inha.how.Domain.entity.Category;
import inha.how.Domain.entity.Excersise;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ExCateId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    Excersise ex;
    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    Category category;
}
