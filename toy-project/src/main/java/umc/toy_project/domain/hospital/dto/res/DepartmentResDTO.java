package umc.toy_project.domain.hospital.dto.res;

import lombok.Builder;
import umc.toy_project.domain.hospital.enums.DepartmentName;

import java.util.List;

public class DepartmentResDTO {

    @Builder
    public record DepartmentInfoDTO(
            Long id,
            DepartmentName name
    ) {
    }

    @Builder
    public record DepartmentInfoListDTO(
            List<DepartmentInfoDTO> departments,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}
