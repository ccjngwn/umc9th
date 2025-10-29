package com.example.umc9th.domain.users.repository;

import com.example.umc9th.domain.users.entity.mapping.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodRepository extends JpaRepository<UserFood, Long> {
}
