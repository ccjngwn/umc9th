package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;

public interface StoreCommandService {
    // 가게에 리뷰 작성
    StoreResDTO.ReviewDTO addReview(
            Long storeId,
            StoreReqDTO.ReviewDTO dto
    );
}
