package umc.toy_project.domain.hospital.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.toy_project.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum HospitalErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "HOSPITAL404_1", "병원을 찾을 수 없습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "HOSPITAL400_1", "잘못된 접근입니다."),
    ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "HOSPITAL400_2", "이미 존재하는 병원입니다."),
    INVALID_ADDRESS(HttpStatus.BAD_REQUEST, "HOSPITAL400_3", "유효하지 않은 주소입니다."),
    ALREADY_ADDRESS(HttpStatus.BAD_REQUEST, "HOSPITAL400_4", "변경하려는 주소의 병원이 이미 존재합니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
