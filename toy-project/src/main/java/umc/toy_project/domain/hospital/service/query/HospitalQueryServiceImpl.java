package umc.toy_project.domain.hospital.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.hospital.converter.HospitalConverter;
import umc.toy_project.domain.hospital.dto.res.HospitalResDTO;
import umc.toy_project.domain.hospital.entity.Hospital;
import umc.toy_project.domain.hospital.exception.HospitalException;
import umc.toy_project.domain.hospital.exception.code.HospitalErrorCode;
import umc.toy_project.domain.hospital.repository.HospitalRepository;
import umc.toy_project.global.enums.PageConstant;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalQueryServiceImpl implements HospitalQueryService{

    private final HospitalRepository hospitalRepository;

    @Override
    public HospitalResDTO.HospitalInfoListDTO getHospitalsByAddress(Integer page, String address) {

        // 빈 문자열 검증
        if (address == null || address.trim().isEmpty()) {
            throw new HospitalException(HospitalErrorCode.INVALID_ADDRESS);
        }

        // 페이징 요청 객체 생성
        PageRequest pageRequest = PageRequest.of(page, PageConstant.DEFAULT_LIMIT.getLimit());

        // 주소로 필터링하여 병원 조회
        Page<Hospital> result = hospitalRepository.findAllByAddressContaining(address, pageRequest);

        // DTO 변환 및 반환
        return HospitalConverter.toHospitalInfoListDTO(result);
    }

    @Override
    public HospitalResDTO.HospitalInfoListDTO getAllHospitals(Integer page) {

        // 페이징 요청 객체 생성
        PageRequest pageRequest = PageRequest.of(page, PageConstant.DEFAULT_LIMIT.getLimit());

        // 페이징으로 병원 조회
        Page<Hospital> result = hospitalRepository.findAll(pageRequest);

        // DTO 변환 및 반환
        return HospitalConverter.toHospitalInfoListDTO(result);
    }
}
