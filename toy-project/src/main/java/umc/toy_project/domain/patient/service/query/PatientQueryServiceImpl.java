package umc.toy_project.domain.patient.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.patient.converter.PatientConverter;
import umc.toy_project.domain.patient.dto.res.PatientResDTO;
import umc.toy_project.domain.patient.entity.Patient;
import umc.toy_project.domain.patient.exception.PatientException;
import umc.toy_project.domain.patient.exception.code.PatientErrorCode;
import umc.toy_project.domain.patient.repository.PatientRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PatientQueryServiceImpl implements PatientQueryService {

    private final PatientRepository patientRepository;

    @Override
    public PatientResDTO.PatientInfoDTO getPatientInfo(Long patientId) {

        // 회원조회
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientException(PatientErrorCode.NOT_FOUND));

        // 회원정보 DTO 변환 - Converter 사용
        return PatientConverter.toPatientInfoDTO(patient);
    }
}
