package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.query.ReviewQueryServiceImpl;
import com.example.umc9th.global.annotation.CheckPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewController implements ReviewControllerDocs{

    private final ReviewQueryServiceImpl reviewQueryService;

    @GetMapping("/users/{userId}")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviewByUserId(
            @PathVariable Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Float minStar,
            @RequestParam(required = false) Float maxStar,
            @CheckPage @RequestParam(defaultValue = "1") Integer page
    ) {
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(
                code,
                reviewQueryService.searchReview(userId, storeName, minStar, maxStar, page)
        );
    }

    // 가게의 리뷰 목록 조회
    @GetMapping
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @CheckPage @RequestParam(defaultValue = "1") Integer page
    ) {

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }

}
