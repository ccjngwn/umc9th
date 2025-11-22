package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.response.ReviewResDTO;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.enums.StoreException;
import com.example.umc9th.domain.store.enums.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.domain.users.exception.UserException;
import com.example.umc9th.domain.users.exception.code.UserErrorCode;
import com.example.umc9th.domain.users.repository.UsersRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UsersRepository usersRepository;

    @Override
    public ReviewResDTO.ReviewPreViewListDTO searchReview(Long userId, String storeName, Float minStar, Float maxStar, Integer page) {

        // - 유저를 가져온다(유저 존재 여부 검증)
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

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

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Review> result = reviewRepository.findByUserIdWithFilters(builder, pageRequest);

        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    @Override
    public ReviewResDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    ) {

        // - 가게를 가져온다(가게 존재 여부 검증)
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // - 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        // - 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return ReviewConverter.toReviewPreviewListDTO(result);
    }
}
