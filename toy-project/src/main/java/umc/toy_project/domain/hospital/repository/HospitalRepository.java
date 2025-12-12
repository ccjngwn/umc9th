package umc.toy_project.domain.hospital.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.toy_project.domain.hospital.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    boolean existsByNameAndAddress(String name, String address);

    Page<Hospital> findAllByAddressContaining(String address, Pageable pageable);

    boolean existsByNameAndAddressAndIdNot(String name, String address, Long id);
}
