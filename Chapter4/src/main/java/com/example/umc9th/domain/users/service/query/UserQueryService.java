package com.example.umc9th.domain.users.service.query;

import com.example.umc9th.domain.users.dto.req.UserReqDTO;
import com.example.umc9th.domain.users.dto.res.UserResDTO;
import jakarta.validation.Valid;

public interface UserQueryService {
    UserResDTO.LoginDTO login(UserReqDTO.LoginDTO dto);
}
