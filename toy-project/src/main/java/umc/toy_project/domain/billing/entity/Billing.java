package umc.toy_project.domain.billing.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.toy_project.domain.reservation.entity.Reservation;
import umc.toy_project.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "billing")
public class Billing extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fee", nullable = false)
    private Integer fee;

    @Column(name = "paid", nullable = false)
    @Builder.Default
    private Boolean paid = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserv_id", nullable = false)
    private Reservation reservation;
}
