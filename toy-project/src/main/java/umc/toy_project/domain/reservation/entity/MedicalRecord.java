package umc.toy_project.domain.reservation.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.toy_project.domain.patient.entity.Patient;
import umc.toy_project.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "medical_record")
public class MedicalRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "clinical_notes")
    private String clinicalNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserv_id", nullable = false)
    private Reservation reservation;
}
