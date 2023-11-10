package inha.how.Domain.dto.live;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public interface ParticipateNicksMapping {
    @JsonProperty("nick")
    String getParticipateIdParticipateNick();
}
