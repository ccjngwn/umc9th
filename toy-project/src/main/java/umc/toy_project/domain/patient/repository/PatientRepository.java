package umc.toy_project.domain.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.toy_project.domain.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
