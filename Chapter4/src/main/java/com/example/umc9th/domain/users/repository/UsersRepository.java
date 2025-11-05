package com.example.umc9th.domain.users.repository;

import com.example.umc9th.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
