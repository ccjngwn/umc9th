package com.example.umc9th.domain.users.repository;

import com.example.umc9th.domain.users.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
