package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionQueryService {
    MissionResDTO.MissionListDTO findStoreMission(String storeName, Integer page);

    MissionResDTO.UserMissionListDTO findMyMission(Long userId, Boolean isDone, Integer page);
}
