package umc.toy_project.global.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.toy_project.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;
}
