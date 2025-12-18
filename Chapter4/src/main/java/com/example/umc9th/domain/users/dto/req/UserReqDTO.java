package com.example.umc9th.domain.users.dto.req;

import com.example.umc9th.domain.users.enums.Gender;
import com.example.umc9th.global.Address;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class UserReqDTO {

    public record JoinDTO(
            @NotBlank
            String name,
            @Email
            String email,
            @NotBlank
            String password,
            @NotBlank
            String nickname,
            @NotBlank
            String phoneNum,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotNull
            Address address,
            @NotNull
            String specAddress,
            @ExistFoods
            List<Long> preferCategory
    ) {
    }

    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ) {
    }
}
