package umc.toy_project.domain.patient.dto.res;

import lombok.Builder;
import umc.toy_project.domain.patient.enums.Gender;

import java.time.LocalDateTime;

public class PatientResDTO {

    @Builder
    public record JoinDTO(
            Long id,
            String name,
            LocalDateTime createdAt
    ) {}

    @Builder
    public record PatientInfoDTO(
            Long id,
            String name,
            Integer age,
            Gender gender,
            String phoneNumber,
            String address
    ) {}
}
