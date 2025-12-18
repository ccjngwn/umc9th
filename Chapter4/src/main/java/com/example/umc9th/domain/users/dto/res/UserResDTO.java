package com.example.umc9th.domain.users.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserResDTO {

    @Builder
    public record JoinDTO(
            Long userId,
            LocalDateTime createdAt
    ) {}

    @Builder
    public record LoginDTO(
            Long userId,
            String accessToken
    ) {}
}
