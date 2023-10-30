package inha.how.Service;

import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.Excercise.ExInfoMapping;
import inha.how.Domain.dto.Excercise.ExRes;
import inha.how.Domain.dto.Excercise.ImgUrlMapping;
import inha.how.Domain.entity.Category;
import inha.how.Domain.entity.ExCate;
import inha.how.Domain.entity.Excersise;
import inha.how.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExService {

    private final ExRepository exRepository;
    private final CategoryRepository categoryRepository;
    private final ExCateRepository exCateRepository;
    private final ExImgRepository exImgRepository;
    private final ImgRepository imgRepository;
/*
    public ExRes findEx(Long id){
        //운동 동작 찾기
        Excersise excersise=exRepository.findExcersiseById(id);
        //운동 동작에 맞는 운동부위 찾기
        CateInfoMapping exCate = exCateRepository.findExCateByExCateIdEx(excersise);
        //운동 상세 정보 표시
        Category category = categoryRepository.findCategoryById(exCates);
        ExRes res= new ExRes(exCates, category.getName());

        exCates.forEach((ex)->{
            List<ImgUrlMapping> imgUrlMappings=exImgRepository.findExImgByExImgIdEx(ex.getExCateIdEx());
            res.setImage(imgUrlMappings);
        });


        return res;
    }

 */


}