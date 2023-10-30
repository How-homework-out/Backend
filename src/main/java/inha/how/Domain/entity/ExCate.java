package inha.how.Domain.entity;

import inha.how.Domain.entity.Identify.ExCateId;
import jakarta.persistence.*;
import lombok.Getter;


@Table(name="action_cate")
@Getter
@Entity
public class ExCate {
    @EmbeddedId
    private ExCateId exCateId;
}
