package umc.toy_project.domain.hospital.dto.res;

import lombok.Builder;

import java.util.List;

public class HospitalResDTO {

    @Builder
    public record HospitalInfoDTO(
            Long id,
            String name,
            String address
    ) {}

    @Builder
    public record HospitalInfoListDTO(
            List<HospitalInfoDTO> hospitals,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {
    }
}
