package umc.toy_project.domain.hospital.service.command;

import umc.toy_project.domain.hospital.dto.req.DepartmentReqDTO;
import umc.toy_project.domain.hospital.dto.res.DepartmentResDTO;

public interface DepartmentCommandService {
    DepartmentResDTO.DepartmentInfoDTO create(DepartmentReqDTO.DepartmentInfoDTO dto);

    void delete(Long id);
}
