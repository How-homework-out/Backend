package inha.how.Domain.dto.routine;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public interface RoutineMeDetailMapping {

    Long getId();
    Long getRoutineId();
    String getRoutineSubject();
    Integer getCount();
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime getCreateDate();

}
