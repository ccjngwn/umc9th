package umc.toy_project.domain.hospital.exception;

import umc.toy_project.global.apiPayload.code.BaseErrorCode;
import umc.toy_project.global.apiPayload.exception.GeneralException;

public class DepartmentException extends GeneralException {
    public DepartmentException(BaseErrorCode code) {
        super(code);
    }
}
