package umc.toy_project.domain.hospital.entity;


import jakarta.persistence.*;
import lombok.*;
import umc.toy_project.global.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "hospital")
public class Hospital extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<HospitalDepartment> departments = new ArrayList<>();

    public void update(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
