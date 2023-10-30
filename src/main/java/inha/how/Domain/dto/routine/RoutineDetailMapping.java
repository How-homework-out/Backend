package inha.how.Domain.dto.routine;

import com.fasterxml.jackson.annotation.JsonProperty;
import inha.how.Domain.entity.Excersise;

public interface RoutineDetailMapping {
    Long getId();
    Excersise getEx();
    Long getType();
    Long getSet();
    Long getTime();
    Long getCount();
    Long getRest();
    Long getOrder();
}
