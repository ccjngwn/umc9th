package com.example.umc9th.domain.store.dto.req;

import com.example.umc9th.global.annotation.ExistUser;
import jakarta.validation.constraints.NotNull;

public class StoreReqDTO {

    public record ReviewDTO(
            // TODO: 추후에 JWT로 변경
            @ExistUser
            @NotNull
            Long userId,
            @NotNull
            String content,
            @NotNull
            Float star
    ) {}
}
