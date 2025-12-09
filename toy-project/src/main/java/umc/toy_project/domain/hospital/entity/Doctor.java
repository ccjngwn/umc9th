package umc.toy_project.domain.hospital.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.toy_project.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "doctor")
public class Doctor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 16, nullable = false)
    private String name;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_department_id", nullable = false)
    private HospitalDepartment hospitalDepartment;
}
