package inha.how.Domain.dto.routine;

import inha.how.Domain.entity.Routine;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class allRoutineRes {
    private List<RoutinesResult> routines;

}
