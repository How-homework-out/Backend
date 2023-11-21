package inha.how.Domain.dto.Excercise;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ImgUrlMapping {
    @JsonProperty("img")
    String getExImgIdImgUrl();
}
