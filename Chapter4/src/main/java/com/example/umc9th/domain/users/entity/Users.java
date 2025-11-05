package com.example.umc9th.domain.users.entity;

import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.users.entity.mapping.UserFood;
import com.example.umc9th.global.Address;
import com.example.umc9th.domain.users.enums.Gender;
import com.example.umc9th.domain.users.enums.SocialType;
import com.example.umc9th.domain.users.enums.Status;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "users")
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "nickname", length = 10, nullable = false)
    private String nickname;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "phone_num", length = 13, nullable = false)
    private String phoneNum;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.ACTIVE;

    @Column(name = "inactive_date")
    private LocalDateTime inactiveDate;

    @Column(name = "social_id", nullable = false)
    private String socialId;

    @Column(name = "social_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name = "point", nullable = false)
    @Builder.Default
    private Integer point = 0;

    @Column(name = "address", nullable = false)
    @Enumerated(EnumType.STRING)
    private Address address;

    @Column(name = "address_detail", nullable = false)
    private String addressDetail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserFood> userFoods;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserMission> userMissions;

}
