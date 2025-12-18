package umc.toy_project.domain.patient.service.query;

import umc.toy_project.domain.patient.dto.res.PatientResDTO;

public interface PatientQueryService {

    // 회원조회
    PatientResDTO.PatientInfoDTO getPatientInfo(Long patientId);
}
