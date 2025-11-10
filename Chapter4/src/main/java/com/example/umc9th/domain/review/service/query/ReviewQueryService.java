package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewQueryService {
    List<ReviewResponse> searchReview(Long userId, String storeName, Float minStar, Float maxStar);
}
