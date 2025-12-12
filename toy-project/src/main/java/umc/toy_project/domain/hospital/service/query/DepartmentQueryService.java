package umc.toy_project.domain.hospital.service.query;

import umc.toy_project.domain.hospital.dto.res.DepartmentResDTO;

public interface DepartmentQueryService {
    DepartmentResDTO.DepartmentInfoListDTO getAllDepartments(Integer page);
}
