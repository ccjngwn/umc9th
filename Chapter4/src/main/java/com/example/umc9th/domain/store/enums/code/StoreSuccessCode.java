package com.example.umc9th.domain.store.enums.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK, "STORE200_1", "성공적으로 가게를 조회했습니다."),
    REVIEW_CREATED(HttpStatus.CREATED, "STORE201_1", "성공적으로 리뷰를 작성했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
