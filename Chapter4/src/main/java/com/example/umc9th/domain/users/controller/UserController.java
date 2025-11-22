package com.example.umc9th.domain.users.controller;

import com.example.umc9th.domain.users.dto.req.UserReqDTO;
import com.example.umc9th.domain.users.dto.res.UserResDTO;
import com.example.umc9th.domain.users.exception.code.UserSuccessCode;
import com.example.umc9th.domain.users.service.command.UserCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserCommandService userCommandService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<UserResDTO.JoinDTO> signUp(@RequestBody @Valid UserReqDTO.JoinDTO dto) {
        return ApiResponse.onSuccess(UserSuccessCode.FOUND, userCommandService.signUp(dto));
    }
}
