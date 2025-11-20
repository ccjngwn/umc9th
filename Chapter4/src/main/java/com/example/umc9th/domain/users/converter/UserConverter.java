package com.example.umc9th.domain.users.converter;

import com.example.umc9th.domain.users.dto.req.UserReqDTO;
import com.example.umc9th.domain.users.dto.res.UserResDTO;
import com.example.umc9th.domain.users.entity.Users;

public class UserConverter {

    // Entity -> DTO
    public static UserResDTO.JoinDTO toJoinDTO(Users user){
        return UserResDTO.JoinDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }

    // DTO -> Entity
    public static Users toUser(UserReqDTO.JoinDTO dto) {
        return Users.builder()
                .name(dto.name())
                .birth(dto.birth())
                .address(dto.address())
                .addressDetail(dto.specAddress())
                .gender(dto.gender())
                .build();
    }
}
