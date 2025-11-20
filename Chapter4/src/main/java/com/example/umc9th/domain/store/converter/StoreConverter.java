package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.users.entity.Users;

public class StoreConverter {

    // DTO -> Entity (리뷰 생성)
    public static Review toReview(StoreReqDTO.ReviewDTO request, Users user, Store store) {
        return Review.builder()
                .content(request.content())
                .star(request.star())
                .user(user)
                .store(store)
                .build();
    }

    // Entity -> DTO (응답)
    public static StoreResDTO.ReviewDTO toReviewDTO(Review review) {
        return StoreResDTO.ReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
