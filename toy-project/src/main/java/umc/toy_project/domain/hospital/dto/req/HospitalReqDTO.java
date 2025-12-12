package umc.toy_project.domain.hospital.dto.req;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class HospitalReqDTO {

    public record HospitalInfoDTO(
            @NotBlank(message = "병원 이름을 입력해주세요.")
            @Length(max = 255, message = "병원 이름은 최대 255자까지 입력 가능합니다.")
            String name,

            @NotBlank(message = "주소를 입력해주세요.")
            @Length(max = 255, message = "주소는 최대 255자까지 입력 가능합니다.")
            String address
    ) {}
}
