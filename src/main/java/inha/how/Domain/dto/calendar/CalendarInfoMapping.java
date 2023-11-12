package inha.how.Domain.dto.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CalendarInfoMapping {
    Long getId();
    LocalDate getDate();
    @JsonProperty("rouId")
    Long getRoutineId();
    @JsonProperty("name")
    String getRoutineSubject();
    @JsonProperty("isCheck")
    Boolean getCheck();

}
