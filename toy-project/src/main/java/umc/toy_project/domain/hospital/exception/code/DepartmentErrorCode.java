package umc.toy_project.domain.hospital.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.toy_project.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum DepartmentErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "DEPARTMENT404_1", "진료과를 찾을 수 없습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "DEPARTMENT400_1", "잘못된 접근입니다."),
    ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "DEPARTMENT400_2", "이미 존재하는 진료과입니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
