package inha.how.Domain.dto.routine;

import inha.how.Domain.entity.Action;

public interface RoutineDetailMapping {
    Long getId();
    Action getAction();
    Long getType();
    Long getSet();
    Long getTime();
    Long getCount();
    Long getRest();
    Long getOrder();
}
