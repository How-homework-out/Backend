package inha.how.Domain.dto.routine;

import inha.how.Domain.entity.Excersise;
import jakarta.persistence.Embedded;

public interface RoutineDetailMapping {
    Long getId();
    String getExName();
    Long getType();
    Long getSet();
    Long getTime();
    Long getCount();
    Long getRest();
    Long getOrder();
}
