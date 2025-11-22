package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final UsersRepository usersRepository;
    private final ReviewRepository reviewRepository;

    // 가게에 리뷰 작성
    @Override
    @Transactional
    public StoreResDTO.ReviewDTO addReview(
            Long storeId,
            StoreReqDTO.ReviewDTO dto
    ) {
        // Controller의 @ExistUser, @ExistStore로 이미 검증되었으므로 바로 조회
        Users user = usersRepository.findById(dto.userId()).get();
        Store store = storeRepository.findById(storeId).get();

        // 리뷰 생성 및 저장
        Review review = StoreConverter.toReview(dto, user, store);
        reviewRepository.save(review);

        // 응답 DTO 생성
        return StoreConverter.toReviewDTO(review);
    }
}
