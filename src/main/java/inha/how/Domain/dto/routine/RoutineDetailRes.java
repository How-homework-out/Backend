package inha.how.Domain.dto.routine;

import inha.how.Domain.entity.RoutineDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoutineDetailRes {
    private Long routId;
    private String name;
    private Integer hits;
    private List<RoutinneDetailResult> routineDetails;
}
