package umc.toy_project.domain.patient.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.patient.converter.PatientConverter;
import umc.toy_project.domain.patient.dto.req.PatientReqDTO;
import umc.toy_project.domain.patient.dto.res.PatientResDTO;
import umc.toy_project.domain.patient.entity.Patient;
import umc.toy_project.domain.patient.exception.PatientException;
import umc.toy_project.domain.patient.exception.code.PatientErrorCode;
import umc.toy_project.domain.patient.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientCommandServiceImpl implements PatientCommandService {


    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public PatientResDTO.JoinDTO join(PatientReqDTO.JoinDTO dto) {

        // 환자 생성
        Patient patient = PatientConverter.toPatient(dto);

        // 환자 중복 여부 확인
        if (patientRepository.existsByPhoneNumber(patient.getPhoneNumber())) {
            throw new PatientException(PatientErrorCode.ALREADY_EXISTS);
        }

        // DB 적용
        patientRepository.save(patient);

        // 응답 DTO 생성
        return PatientConverter.toJoinDTO(patient);
    }
}
