package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final UsersRepository usersRepository;
    private final UserMissionRepository userMissionRepository;

    // 유저 미션 등록
    @Override
    @Transactional
    public MissionResDTO.UserMissionDTO challenge(MissionReqDTO.UserMissionDTO dto, Long missionId) {

        // Controller의 @ExistUser, @ExistMission으로 이미 검증되었으므로 바로 조회
        Users user = usersRepository.findById(dto.userId()).get();
        Mission mission = missionRepository.findById(missionId).get();

        // 유저 미션 생성 및 저장
        UserMission userMission = MissionConverter.toUserMission(dto, user, mission);
        userMissionRepository.save(userMission);

        // 응답 DTO 생성
        return MissionConverter.toUserMissionDTO(userMission);
    }
}
