package com.example.umc9th.domain.users.service.command;

import com.example.umc9th.domain.users.dto.req.UserReqDTO;
import com.example.umc9th.domain.users.dto.res.UserResDTO;

public interface UserCommandService {
    // 회원가입
    UserResDTO.JoinDTO signUp(UserReqDTO.JoinDTO dto);
}
