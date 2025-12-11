package umc.toy_project.domain.patient.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.toy_project.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum PatientErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "PATIENT404_1", "환자를 찾을 수 없습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "PATIENT400_1", "잘못된 접근입니다."),
    ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "PATIENT400_2", "이미 존재하는 회원입니다."),
    ALREADY_PHONE_NUM(HttpStatus.BAD_REQUEST, "PATIENT400_3", "변경하려는 전화번호가 이미 존재합니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
