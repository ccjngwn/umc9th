package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;
import com.example.umc9th.domain.store.enums.code.StoreSuccessCode;
import com.example.umc9th.domain.store.service.command.StoreCommandService;
import com.example.umc9th.global.annotation.ExistStore;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class StoreController {

    private final StoreCommandService storeCommandService;

    // 가게에 리뷰 추가
    @PostMapping("/api/stores/{storeId}/reviews")
    public ApiResponse<StoreResDTO.ReviewDTO> addReview(
            @ExistStore @PathVariable Long storeId,
            @Valid @RequestBody StoreReqDTO.ReviewDTO dto
    ) {
        return ApiResponse.onSuccess(StoreSuccessCode.REVIEW_CREATED, storeCommandService.addReview(storeId, dto));
    }
}
