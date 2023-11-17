package inha.how.Domain.dto.live;

import inha.how.Domain.dto.routine.RoutinneDetailResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class liveRoutRes {
    private Long routId;
    private String name;
    private Integer hits;
    private Long actionCnt;
    private Set<String> cate;
    private List<RoutinneDetailResult> routineDetails;
}
