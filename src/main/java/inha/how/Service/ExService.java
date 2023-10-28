package inha.how.Service;

import inha.how.Domain.dto.Excercise.ExInfoMapping;
import inha.how.Domain.dto.Excercise.ExRes;
import inha.how.Domain.entity.Category;
import inha.how.Domain.entity.ExCate;
import inha.how.Repository.CategoryRepository;
import inha.how.Repository.ExCateRepository;
import inha.how.Repository.ExRepository;
import inha.how.Repository.ImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExService {

    private final ExRepository exRepository;
    private final CategoryRepository categoryRepository;
    private final ExCateRepository exCateRepository;
    private final ImgRepository imgRepository;

    public ExRes findEx(Long tagid){
        Category category = categoryRepository.findCategoryById(tagid);
        List<ExInfoMapping> exCates = exCateRepository.findExCateByExCateIdCategory(category);

        return new ExRes(exCates);
    }
}
