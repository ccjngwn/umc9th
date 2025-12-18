package umc.toy_project.domain.hospital.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.toy_project.domain.hospital.enums.DepartmentName;
import umc.toy_project.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "department")
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private DepartmentName name;
}
