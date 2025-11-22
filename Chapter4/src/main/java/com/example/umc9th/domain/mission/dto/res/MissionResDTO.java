package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    public record MissionListDTO(
            List<MissionInfo> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record UserMissionListDTO(
            List<UserMissionDTO> userMissionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}
