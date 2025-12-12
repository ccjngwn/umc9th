package umc.toy_project.domain.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.toy_project.domain.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
