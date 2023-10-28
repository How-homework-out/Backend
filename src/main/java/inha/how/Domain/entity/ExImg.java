package inha.how.Domain.entity;

import inha.how.Domain.entity.Identify.ExImgId;
import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "action_img")
@Getter
@Entity
public class ExImg {
    @EmbeddedId
    private ExImgId exImgId;

}
