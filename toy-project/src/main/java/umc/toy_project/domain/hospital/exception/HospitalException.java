package umc.toy_project.domain.hospital.exception;

import umc.toy_project.global.apiPayload.code.BaseErrorCode;
import umc.toy_project.global.apiPayload.exception.GeneralException;

public class HospitalException extends GeneralException {
    public HospitalException(BaseErrorCode code) {
        super(code);
    }
}
