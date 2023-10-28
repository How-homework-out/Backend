package inha.how.Domain.dto.Excercise;

import inha.how.Domain.entity.ExCate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExRes {
    List<ExInfoMapping> exInfoMappingList;
}
