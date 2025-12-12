package umc.toy_project.domain.hospital.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.toy_project.global.apiPayload.code.BaseSuccessCode;

@Getter
@AllArgsConstructor
public enum HospitalSuccessCode implements BaseSuccessCode {
    SUCCESS_CODE(HttpStatus.OK, "HOSPITAL200_1", "병원 관련 요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "HOSPITAL201_1", "성공적으로 병원을 등록했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
