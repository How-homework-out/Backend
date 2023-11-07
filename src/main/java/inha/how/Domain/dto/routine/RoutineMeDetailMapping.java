package inha.how.Domain.dto.routine;

import java.time.LocalDateTime;

public interface RoutineMeDetailMapping {
    //운동 id
    //운동 제목
    //운동 횟수
    //내 루틴 생성 일자

    Long getRoutineId();
    String getRoutineSubject();
    Integer getCount();
    LocalDateTime getCreateDate();

}
