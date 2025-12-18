package umc.toy_project.domain.hospital.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.hospital.converter.HospitalConverter;
import umc.toy_project.domain.hospital.dto.req.HospitalReqDTO;
import umc.toy_project.domain.hospital.dto.res.HospitalResDTO;
import umc.toy_project.domain.hospital.entity.Hospital;
import umc.toy_project.domain.hospital.exception.HospitalException;
import umc.toy_project.domain.hospital.exception.code.HospitalErrorCode;
import umc.toy_project.domain.hospital.repository.HospitalRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalCommandServiceImpl implements HospitalCommandService{

    private final HospitalRepository hospitalRepository;

    @Override
    @Transactional
    public HospitalResDTO.HospitalInfoDTO create(HospitalReqDTO.HospitalInfoDTO dto) {

        // 병원 생성
        Hospital hospital = HospitalConverter.toHospital(dto);

        // 병원 존재 확인
        if (hospitalRepository.existsByNameAndAddress(dto.name(), dto.address())) {
            throw new HospitalException(HospitalErrorCode.ALREADY_EXISTS);
        }

        // DB 적용
        hospitalRepository.save(hospital);

        // 응답 DTO 생성
        return HospitalConverter.toHospitalInfoDTO(hospital);
    }

    @Override
    @Transactional
    public HospitalResDTO.HospitalInfoDTO update(Long id, HospitalReqDTO.HospitalInfoDTO dto) {

        // 병원 조회
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new HospitalException(HospitalErrorCode.NOT_FOUND));

        // 주소, 이름 중복 체크
        if (hospitalRepository.existsByNameAndAddressAndIdNot(dto.name(), dto.address(), id)) {
            throw new HospitalException(HospitalErrorCode.ALREADY_ADDRESS);
        }

        // 병원 정보 수정
        hospital.update(dto.name(), dto.address());

        // 수정된 정보 반환
        return HospitalConverter.toHospitalInfoDTO(hospital);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        // 병원 조회
        Hospital hospital = hospitalRepository.findById(id)
                        .orElseThrow(() -> new HospitalException(HospitalErrorCode.NOT_FOUND));

        // 병원 삭제
        hospitalRepository.delete(hospital);
    }
}
