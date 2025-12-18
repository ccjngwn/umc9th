package umc.toy_project.domain.hospital.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.toy_project.global.apiPayload.code.BaseSuccessCode;

@Getter
@AllArgsConstructor
public enum DepartmentSuccessCode implements BaseSuccessCode {
    SUCCESS_CODE(HttpStatus.OK, "DEPARTMENT200_1", "진료과 관련 요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "DEPARTMENT201_1", "성공적으로 진료과가 등록되었습니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT, "DEPARTMENT204_1", "성공적으로 진료과를 삭제했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
