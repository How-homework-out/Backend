package inha.how.Repository;

import inha.how.Domain.dto.Excercise.ImgUrlMapping;
import inha.how.Domain.entity.ExImg;
import inha.how.Domain.entity.Excersise;
import inha.how.Domain.entity.Identify.ExImgId;
import inha.how.Domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExImgRepository extends JpaRepository<ExImg, ExImgId> {
    List<ImgUrlMapping> findExImgByExImgIdEx(Excersise excersise);
}
