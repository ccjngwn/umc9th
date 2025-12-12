package umc.toy_project.domain.hospital.converter;

import org.springframework.data.domain.Page;
import umc.toy_project.domain.hospital.dto.req.HospitalReqDTO;
import umc.toy_project.domain.hospital.dto.res.HospitalResDTO;
import umc.toy_project.domain.hospital.entity.Hospital;

public class HospitalConverter {

    // Entity -> DTO
    public static HospitalResDTO.HospitalInfoDTO toHospitalInfoDTO(Hospital hospital) {
        return HospitalResDTO.HospitalInfoDTO.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .address(hospital.getAddress())
                .build();
    }

    // DTO -> Entity
    public static Hospital toHospital(HospitalReqDTO.HospitalInfoDTO dto) {
        return Hospital.builder()
                .name(dto.name())
                .address(dto.address())
                .build();
    }

    // DTO -> Entity
    public static HospitalResDTO.HospitalInfoListDTO toHospitalInfoListDTO(Page<Hospital> result) {
        return HospitalResDTO.HospitalInfoListDTO.builder()
                .hospitals(result.getContent().stream()
                        .map(HospitalConverter::toHospitalInfoDTO)
                        .toList())
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
}
