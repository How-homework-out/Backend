package inha.how.Domain.dto.routine;

import inha.how.Domain.entity.Routine;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class allRoutineRes {
    List<Routine> routines;
}
