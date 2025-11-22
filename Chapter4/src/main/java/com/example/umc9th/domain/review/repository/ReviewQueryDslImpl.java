package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Review> findByUserIdWithFilters(Predicate predicate, Pageable pageable) {
        QReview review = QReview.review;

        List<Review> reviewList = jpaQueryFactory
                .selectFrom(review)
                .leftJoin(review.store).fetchJoin()
                .leftJoin(review.user).fetchJoin()
                .where(predicate)
                .orderBy(review.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = jpaQueryFactory
                .select(review.count())
                .from(review)
                .where(predicate)
                .fetchOne();

        return new PageImpl<>(reviewList, pageable, total != null ? total : 0L);
    }
}
