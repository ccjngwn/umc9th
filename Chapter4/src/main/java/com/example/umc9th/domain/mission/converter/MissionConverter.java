package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.users.entity.Users;

public class MissionConverter {

    // Entity -> DTO
    public static MissionResDTO.UserMissionDTO toUserMissionDTO(UserMission userMission) {

        MissionResDTO.MissionInfo mission = MissionResDTO.MissionInfo.builder()
                .missionId(userMission.getMission().getId())
                .conditional(userMission.getMission().getConditional())
                .point(userMission.getMission().getPoint())
                .deadline(userMission.getMission().getDeadline())
                .storeName(userMission.getMission().getStore().getName())
                .build();

        return MissionResDTO.UserMissionDTO.builder()
                .userMissionId(userMission.getId())
                .isDone(userMission.getIsDone())
                .createdAt(userMission.getCreatedAt())
                .mission(mission)
                .build();
    }

    // DTO -> Entity
    public static UserMission toUserMission(MissionReqDTO.UserMissionDTO dto, Users user, Mission mission) {
        return UserMission.builder()
                .isDone(false)
                .user(user)
                .mission(mission)
                .build();
    }
}
