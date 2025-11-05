package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.response.ReviewResponse;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.users.entity.QUsers;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReviewResponse> findByUserIdWithFilters(Predicate predicate) {
        QReview review = QReview.review;

        List<Review> reviewList = jpaQueryFactory
                .selectFrom(review)
                .leftJoin(review.store).fetchJoin()
                .leftJoin(review.user).fetchJoin()
                .where(predicate)
                .orderBy(review.createdAt.desc())
                .fetch();

        return reviewList.stream()
                .map(ReviewResponse::from)
                .toList();
    }
}
