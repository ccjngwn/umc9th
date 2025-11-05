package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("select um from UserMission um " +
            "join fetch um.mission m " +
            "join fetch m.store s " +
            "where um.user.id = :userId " +
            "and (:lastMissionId is null or m.id < :lastMissionId) " +
            "order by um.updatedAt desc")
    List<UserMission> findUserMissions(
            @Param("userId") Long userId,
            @Param("lastMissionId") Long lastMissionId,
            Pageable pageable
    );
}
