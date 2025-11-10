package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.ReviewResponse;
import com.example.umc9th.domain.review.service.query.ReviewQueryServiceImpl;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryServiceImpl reviewQueryService;

    @GetMapping("/users/{userId}")
    public ApiResponse<List<ReviewResponse>> getReviewByUserId(
            @PathVariable Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Float minStar,
            @RequestParam(required = false) Float maxStar
    ) throws Exception {
        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                reviewQueryService.searchReview(userId, storeName, minStar, maxStar)
        );
    }
}
