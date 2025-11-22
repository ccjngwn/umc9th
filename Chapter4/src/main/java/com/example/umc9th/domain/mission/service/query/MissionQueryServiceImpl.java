package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.enums.StoreException;
import com.example.umc9th.domain.store.enums.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.domain.users.exception.UserException;
import com.example.umc9th.domain.users.exception.code.UserErrorCode;
import com.example.umc9th.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UsersRepository usersRepository;
    private final UserMissionRepository userMissionRepository;

    // 특정 가게의 미션 목록 조회 API
    @Override
    public MissionResDTO.MissionListDTO findStoreMission(String storeName, Integer page) {

        // - 가게를 가져온다 (가게 존재 여부 검증)
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // - 가게에 맞는 미션을 가져온다 (Offset 페이징, 1-based -> 0-based 변환)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<Mission> result = missionRepository.findAllByStore(store, pageRequest);

        // - 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return MissionConverter.toMissionListDTO(result);
    }

    @Override
    public MissionResDTO.UserMissionListDTO findMyMission(Long userId, Boolean isDone, Integer page) {

        // - 유저를 가져온다 (유저 존재 여부 검증)
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        // - 유저의 미션을 가져온다 (Offset 페이징, 1-based -> 0-based 변환)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<UserMission> result;

        if (isDone == null) {
            // isDone이 null이면 전체 조회
            result = userMissionRepository.findAllByUser(user, pageRequest);
        } else {
            // isDone 값에 따라 필터링
            result = userMissionRepository.findAllByUserAndIsDone(user, isDone, pageRequest);
        }

        // - 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return MissionConverter.toUserMissionListDTO(result);
    }
}
