package inha.how.Domain.dto.routine;

import inha.how.Domain.dto.Excercise.CateInfoMapping;
import inha.how.Domain.dto.Excercise.ImgUrlMapping;
import inha.how.Domain.entity.Excersise;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RoutinneDetailResult {
    private Long id;
    private Excersise ex;
    private Long type;
    private Long set;
    private Long time;
    private Long count;
    private Long rest;
    private Long order;
    private List<ImgUrlMapping> img;
    private List<CateInfoMapping> cate;

}
