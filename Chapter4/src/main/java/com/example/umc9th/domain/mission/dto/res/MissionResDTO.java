package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResDTO {

    @Builder
    public record UserMissionDTO(
            Long userMissionId,
            Boolean isDone,
            LocalDateTime createdAt,
            MissionInfo mission
    ) {}

    @Builder
    public record MissionInfo(
            Long missionId,
            String conditional,
            Integer point,
            LocalDate deadline,
            String storeName
    ) {}
}
