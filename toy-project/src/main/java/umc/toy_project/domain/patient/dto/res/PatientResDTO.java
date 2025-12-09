package umc.toy_project.domain.patient.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class PatientResDTO {

    @Builder
    public record JoinDTO(
            Long id,
            String name,
            LocalDateTime createdAt
    ) {}
}
