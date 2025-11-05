package com.example.umc9th.domain.review.dto.response;

import com.example.umc9th.domain.review.entity.Review;

public record ReviewResponse(
        Long reviewId,
        String storeName,
        String content,
        Float star
) {
    public static ReviewResponse from(Review review) {
        return new ReviewResponse(review.getId(), review.getStore().getName(), review.getContent(), review.getStar());
    }
}
