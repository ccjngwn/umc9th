package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.response.ReviewResponse;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> searchReview(Long userId, String storeName, Float minStar, Float maxStar) {

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        builder.and(review.user.id.eq(userId));

        if (storeName != null && !storeName.isEmpty()) {
            builder.and(review.store.name.eq(storeName));
        }

        if (minStar != null && maxStar != null) {
            builder.and(review.star.between(minStar, maxStar));
        } else if (minStar != null) {
            builder.and(review.star.goe(minStar));
        } else if (maxStar != null) {
            builder.and(review.star.loe(maxStar));
        }

        return reviewRepository.findByUserIdWithFilters(builder);
    }
}
