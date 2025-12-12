package umc.toy_project.domain.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.toy_project.domain.hospital.entity.HospitalDepartment;

public interface HospitalDepartmentRepository extends JpaRepository<HospitalDepartment, Long> {
}
