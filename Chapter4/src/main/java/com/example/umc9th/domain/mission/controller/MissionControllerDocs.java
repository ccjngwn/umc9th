package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.global.annotation.CheckPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MissionControllerDocs {
    @Operation(
            summary = "특정 가게의 미션 목록 조회 API By 정원",
            description = "특정 가게의 미션 목록을 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음")
    })
    ApiResponse<MissionResDTO.MissionListDTO> getStoreMission(String storeName, @CheckPage Integer page);

    @Operation(
            summary = "내 미션 목록 조회 API By 정원",
            description = "내 미션 목록을 조회합니다. isDone=true(완료), isDone=false(진행중), isDone 미입력(전체). 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저를 찾을 수 없음")
    })
    ApiResponse<MissionResDTO.UserMissionListDTO> getMyMission(Long userId, Boolean isDone, @CheckPage Integer page);
}
