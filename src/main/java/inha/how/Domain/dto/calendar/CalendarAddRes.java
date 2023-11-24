package inha.how.Domain.dto.calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalendarAddRes {
    private LocalDate localDate;
    private Long routId;
    private Boolean check;
}
