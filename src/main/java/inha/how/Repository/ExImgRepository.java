package inha.how.Repository;

import inha.how.Domain.entity.ExImg;
import inha.how.Domain.entity.Excersise;
import inha.how.Domain.entity.Identify.ExImgId;
import inha.how.Domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExImgRepository extends JpaRepository<ExImg, ExImgId> {

}
