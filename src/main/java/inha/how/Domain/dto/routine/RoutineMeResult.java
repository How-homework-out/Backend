package inha.how.Domain.dto.routine;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class RoutineMeResult {
    private RoutineMeDetailMapping routine;
    private Set<String> cate;
}
