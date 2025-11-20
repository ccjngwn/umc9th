package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.annotation.ExistMission;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionController {

    private final MissionCommandService missionCommandService;

    // 미션 도전하기
    @PostMapping("/api/missions/{missionId}/challenge")
    public ApiResponse<MissionResDTO.UserMissionDTO> challenge(
            @ExistMission @PathVariable Long missionId,
            @Valid @RequestBody MissionReqDTO.UserMissionDTO dto
    ) {
        return ApiResponse.onSuccess(MissionSuccessCode.CHALLENGE_SUCCESS, missionCommandService.challenge(dto, missionId));
    }
}
