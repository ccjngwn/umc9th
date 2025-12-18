package umc.toy_project.domain.patient.dto.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import umc.toy_project.domain.patient.enums.Gender;

public class PatientReqDTO {

    public record JoinDTO(
            @NotBlank(message = "이름을 입력해주세요")
            @Length(max = 16, message = "이름은 최대 16자까지 입력 가능합니다")
            String name,

            @NotNull(message = "나이를 입력해주세요")
            @Min(value = 0, message = "나이는 0세 이상이어야 합니다")
            @Max(value = 150, message = "나이는 150세 이하여야 합니다")
            Integer age,

            @NotNull(message = "성별을 선택해주세요")
            Gender gender,

            @NotBlank(message = "전화번호를 입력해주세요")
            @Length(min = 11, max = 11, message = "전화번호는 11자리여야 합니다")
            String phoneNumber,

            @NotBlank(message = "주소를 입력해주세요")
            @Length(max = 255, message = "주소는 최대 255자까지 입력 가능합니다")
            String address
    ) {}
}
