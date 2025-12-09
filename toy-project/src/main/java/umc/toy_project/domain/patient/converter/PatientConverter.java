package umc.toy_project.domain.patient.converter;

import umc.toy_project.domain.patient.dto.req.PatientReqDTO;
import umc.toy_project.domain.patient.dto.res.PatientResDTO;
import umc.toy_project.domain.patient.entity.Patient;

public class PatientConverter {

    // Entity -> DTO
    public static PatientResDTO.JoinDTO toJoinDTO(Patient patient) {
        return PatientResDTO.JoinDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .createdAt(patient.getCreatedAt())
                .build();
    }

    // DTO -> Entity
    public static Patient toPatient(PatientReqDTO.JoinDTO dto) {
        return Patient.builder()
                .name(dto.name())
                .age(dto.age())
                .gender(dto.gender())
                .phoneNumber(dto.phoneNumber())
                .address(dto.address())
                .build();
    }
}
