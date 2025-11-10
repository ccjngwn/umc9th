package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.ReviewResponse;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/users/{userId}")
    public List<ReviewResponse> getReviewByUserId(
            @PathVariable Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Float minStar,
            @RequestParam(required = false) Float maxStar
    ) {

        return reviewQueryService.searchReview(userId, storeName, minStar, maxStar);
    }
}
