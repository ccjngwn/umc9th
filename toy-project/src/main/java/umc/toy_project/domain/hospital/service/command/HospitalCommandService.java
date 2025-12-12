package umc.toy_project.domain.hospital.service.command;

import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.hospital.dto.req.HospitalReqDTO;
import umc.toy_project.domain.hospital.dto.res.HospitalResDTO;

public interface HospitalCommandService {
    HospitalResDTO.HospitalInfoDTO create(HospitalReqDTO.HospitalInfoDTO dto);

    HospitalResDTO.HospitalInfoDTO update(Long id, HospitalReqDTO.HospitalInfoDTO dto);
}
