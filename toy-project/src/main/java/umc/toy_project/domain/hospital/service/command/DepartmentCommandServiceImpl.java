package umc.toy_project.domain.hospital.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.toy_project.domain.hospital.converter.DepartmentConverter;
import umc.toy_project.domain.hospital.dto.req.DepartmentReqDTO;
import umc.toy_project.domain.hospital.dto.res.DepartmentResDTO;
import umc.toy_project.domain.hospital.entity.Department;
import umc.toy_project.domain.hospital.exception.DepartmentException;
import umc.toy_project.domain.hospital.exception.code.DepartmentErrorCode;
import umc.toy_project.domain.hospital.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentCommandServiceImpl implements DepartmentCommandService {

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public DepartmentResDTO.DepartmentInfoDTO create(DepartmentReqDTO.DepartmentInfoDTO dto) {

        // 진료과 존재 여부 확인
        if (departmentRepository.existsByName(dto.name())) {
            throw new DepartmentException(DepartmentErrorCode.ALREADY_EXISTS);
        }

        // 진료과 생성
        Department department = DepartmentConverter.toDepartment(dto);

        // DB 적용
        departmentRepository.save(department);

        // 결과 반환
        return DepartmentConverter.toDepartmentInfoDTO(department);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        // 진료과 존재 여부 확인
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentException(DepartmentErrorCode.NOT_FOUND);
        }

        departmentRepository.deleteById(id);
    }
}
