package umc.toy_project.domain.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.toy_project.domain.hospital.entity.Department;
import umc.toy_project.domain.hospital.enums.DepartmentName;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByName(DepartmentName name);
}
