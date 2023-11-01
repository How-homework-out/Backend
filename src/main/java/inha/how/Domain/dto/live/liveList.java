package inha.how.Domain.dto.live;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class liveList {
    private Long Id;
    private String Subject;
    private String Nick;
    //라이브 참여자 수 써야 함
    private Long RoutineId;
}
