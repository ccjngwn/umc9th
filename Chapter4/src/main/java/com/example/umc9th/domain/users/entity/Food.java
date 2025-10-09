package com.example.umc9th.domain.users.entity;


import com.example.umc9th.domain.users.entity.mapping.UserFood;
import com.example.umc9th.domain.users.enums.FoodName;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "food")
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private FoodName name;

    @OneToMany(mappedBy = "food", cascade = CascadeType.REMOVE)
    private List<UserFood> userFoods;
}
