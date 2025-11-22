package com.example.umc9th.domain.mission.dto.req;

import com.example.umc9th.global.annotation.ExistUser;
import jakarta.validation.constraints.NotNull;

public class MissionReqDTO {

    public record UserMissionDTO(
            @ExistUser
            @NotNull
            Long userId
    ) {
    }
}
