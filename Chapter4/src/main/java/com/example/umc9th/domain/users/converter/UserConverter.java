package com.example.umc9th.domain.users.converter;

import com.example.umc9th.domain.users.dto.req.UserReqDTO;
import com.example.umc9th.domain.users.dto.res.UserResDTO;
import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.global.auth.enums.Role;

public class UserConverter {

    // Entity -> DTO
    public static UserResDTO.JoinDTO toJoinDTO(Users user){
        return UserResDTO.JoinDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }

    // DTO -> Entity
    public static Users toUser(UserReqDTO.JoinDTO dto, String password, Role role) {
        return Users.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .nickname(dto.nickname())
                .phoneNum(dto.phoneNum())
                .birth(dto.birth())
                .address(dto.address())
                .addressDetail(dto.specAddress())
                .gender(dto.gender())
                .build();
    }

    public static UserResDTO.LoginDTO toLoginDTO(Users user, String accessToken) {
        return UserResDTO.LoginDTO.builder()
                .userId(user.getId())
                .accessToken(accessToken)
                .build();
    }
}
