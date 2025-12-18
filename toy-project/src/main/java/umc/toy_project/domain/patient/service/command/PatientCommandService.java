package umc.toy_project.domain.patient.service.command;

import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.patient.dto.req.PatientReqDTO;
import umc.toy_project.domain.patient.dto.res.PatientResDTO;

public interface PatientCommandService {

    // 회원가입
    PatientResDTO.JoinDTO join(PatientReqDTO.JoinDTO dto);

    PatientResDTO.JoinDTO update(Long id, PatientReqDTO.JoinDTO dto);

    void delete(Long id);
}
