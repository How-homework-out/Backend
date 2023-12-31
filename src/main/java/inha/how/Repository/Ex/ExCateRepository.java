package inha.how.Repository.Ex;

import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.Excercise.ExInfoMapping;
import inha.how.Domain.entity.Category;
import inha.how.Domain.entity.ExCate;
import inha.how.Domain.entity.Excersise;
import inha.how.Domain.entity.Identify.ExCateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExCateRepository extends JpaRepository<ExCate, ExCateId> {
    List<CateInfoMapping> findExCateByExCateIdEx(Excersise excersise);

}
