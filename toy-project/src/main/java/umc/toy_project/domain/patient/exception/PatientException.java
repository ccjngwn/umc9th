package umc.toy_project.domain.patient.exception;

import umc.toy_project.global.apiPayload.code.BaseErrorCode;
import umc.toy_project.global.apiPayload.exception.GeneralException;

public class PatientException extends GeneralException {
    public PatientException(BaseErrorCode code) {
        super(code);
    }
}
