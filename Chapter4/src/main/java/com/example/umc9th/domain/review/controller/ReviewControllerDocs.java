package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.ReviewResDTO;
import com.example.umc9th.global.annotation.CheckPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ReviewControllerDocs {

    @Operation(
            summary = "내가 작성한 리뷰 목록 조회 API By 정원",
            description = "내가 작성한 리뷰를 조회합니다. 가게명, 별점 범위 필터링과 페이지네이션을 지원합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저를 찾을 수 없음")
    })
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviewByUserId(
            @Parameter(description = "유저 ID", required = true) Long userId,
            @Parameter(description = "가게 이름 (필터)") String storeName,
            @Parameter(description = "최소 별점 (필터)") Float minStar,
            @Parameter(description = "최대 별점 (필터)") Float maxStar,
            @CheckPage @Parameter(description = "페이지 번호 (0부터 시작)") Integer page
    );

    @Operation(
            summary = "가게의 리뷰 목록 조회 API By 정원",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음")
    })
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @Parameter(description = "가게 이름", required = true) String storeName,
            @CheckPage @Parameter(description = "페이지 번호 (0부터 시작)", required = true) Integer page
    );
}
