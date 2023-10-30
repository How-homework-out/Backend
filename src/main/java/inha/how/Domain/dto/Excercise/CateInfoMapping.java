package inha.how.Domain.dto.Excercise;


import com.fasterxml.jackson.annotation.JsonProperty;

public interface CateInfoMapping {
    @JsonProperty("name")
    String getExCateIdCategoryName();
}
