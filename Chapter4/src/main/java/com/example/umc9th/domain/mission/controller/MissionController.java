package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.annotation.CheckPage;
import com.example.umc9th.global.annotation.ExistMission;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
@Validated
public class MissionController implements MissionControllerDocs {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    // 미션 도전하기
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionResDTO.UserMissionDTO> challenge(
            @ExistMission @PathVariable Long missionId,
            @Valid @RequestBody MissionReqDTO.UserMissionDTO dto
    ) {
        return ApiResponse.onSuccess(MissionSuccessCode.CHALLENGE_SUCCESS, missionCommandService.challenge(dto, missionId));
    }

    // 특정 가게의 미션 목록 조회 API
    @GetMapping
    public ApiResponse<MissionResDTO.MissionListDTO> getStoreMission(
            @RequestParam String storeName,
            @CheckPage @RequestParam(defaultValue = "1") Integer page
    ) {
        MissionSuccessCode code = MissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, missionQueryService.findStoreMission(storeName, page));
    }

    @GetMapping("/users")
    public ApiResponse<MissionResDTO.UserMissionListDTO> getMyMission(
            @RequestParam Long userId,
            @RequestParam(required = false) Boolean isDone,
            @CheckPage @RequestParam(defaultValue = "1") Integer page
    ) {
        MissionSuccessCode code = MissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, missionQueryService.findMyMission(userId, isDone, page));
    }
}
