package inha.how.Domain.dto.routine;

import inha.how.Domain.entity.Routine;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class RoutinesResult {
    private Routine routine;
    private Set<String> cate;
}
