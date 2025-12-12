package umc.toy_project.domain.hospital.dto.req;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import umc.toy_project.domain.hospital.enums.DepartmentName;

public class DepartmentReqDTO {

    public record DepartmentInfoDTO(
            @NotNull(message = "진료과 이름을 입력해주세요.")
            DepartmentName name
    ) {
    }
}
