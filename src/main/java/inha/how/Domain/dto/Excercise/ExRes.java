package inha.how.Domain.dto.Excercise;

import inha.how.Domain.entity.ExCate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ExRes {
    private final List<ExInfoMapping> exInfoMappingList;
    private final String tag;
    private List<ImgUrlMapping> image;

    public void setImage(List<ImgUrlMapping> image){
        this.image=image;
    }
}
