package umc.toy_project.domain.hospital.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.hospital.converter.DepartmentConverter;
import umc.toy_project.domain.hospital.dto.res.DepartmentResDTO;
import umc.toy_project.domain.hospital.entity.Department;
import umc.toy_project.domain.hospital.repository.DepartmentRepository;
import umc.toy_project.global.enums.PageConstant;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentQueryServiceImpl implements DepartmentQueryService{

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResDTO.DepartmentInfoListDTO getAllDepartments(Integer page) {

        // 페이지 요청 객체 생성
        PageRequest pageRequest = PageRequest.of(page, PageConstant.DEFAULT_LIMIT.getLimit());

        // 페이징으로 진료과 조회
        Page<Department> result = departmentRepository.findAll(pageRequest);

        // DTO 변환 및 반환
        return DepartmentConverter.toDepartmentInfoListDTO(result);
    }
}
