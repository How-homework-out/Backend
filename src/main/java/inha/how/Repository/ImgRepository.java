package inha.how.Repository;

import inha.how.Domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRepository extends JpaRepository<Image, Long> {
    Image findImageById(Long id);
}
