package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.response.ReviewResDTO;

public interface ReviewQueryService {
    ReviewResDTO.ReviewPreViewListDTO searchReview(Long userId, String storeName, Float minStar, Float maxStar, Integer page);

    ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page);
}
