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
@Transactional(readOnly = true)
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

    @Override
    @Transactional
    public PatientResDTO.JoinDTO update(Long id, PatientReqDTO.JoinDTO dto) {

        // 환자 조회
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientException(PatientErrorCode.NOT_FOUND));

        // 전화번호 중복 체크
        if (patientRepository.existsByPhoneNumberAndIdNot(dto.phoneNumber(), id)) {
            throw new PatientException(PatientErrorCode.ALREADY_PHONE_NUM);
        }

        // 환자 정보 수정
        patient.update(dto.name(), dto.age(), dto.gender(), dto.phoneNumber(), dto.address());

        // 수정된 정보 반환
        return PatientConverter.toJoinDTO(patient);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        // 환자 존재 확인
        if (!patientRepository.existsById(id)) {
            throw new PatientException(PatientErrorCode.NOT_FOUND);
        }

        // 환자 삭제
        patientRepository.deleteById(id);
    }
}
