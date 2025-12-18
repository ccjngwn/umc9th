package umc.toy_project.domain.hospital.converter;

import org.springframework.data.domain.Page;
import umc.toy_project.domain.hospital.dto.req.DepartmentReqDTO;
import umc.toy_project.domain.hospital.dto.res.DepartmentResDTO;
import umc.toy_project.domain.hospital.entity.Department;

public class DepartmentConverter {

    // Entity -> DTO
    public static DepartmentResDTO.DepartmentInfoDTO toDepartmentInfoDTO(Department department) {
        return DepartmentResDTO.DepartmentInfoDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }

    // DTO -> Entity
    public static Department toDepartment(DepartmentReqDTO.DepartmentInfoDTO dto) {
        return Department.builder()
                .name(dto.name())
                .build();
    }

    // Entity -> DTO
    public static DepartmentResDTO.DepartmentInfoListDTO toDepartmentInfoListDTO(Page<Department> result) {
        return DepartmentResDTO.DepartmentInfoListDTO.builder()
                .departments(result.getContent().stream()
                        .map(DepartmentConverter::toDepartmentInfoDTO)
                        .toList())
                .listSize(result.getNumberOfElements())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
}
