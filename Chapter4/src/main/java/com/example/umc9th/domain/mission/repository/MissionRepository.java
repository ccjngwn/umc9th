package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select m from Mission m " +
            "join fetch m.store s " +
            "where s.address = (select u.address from Users u where u.id = :userId) " +
            "and m.deadline > current_timestamp " +
            "and not exists (" +
                "select um from UserMission um " +
                "where um.mission.id = m.id and um.user.id = :userId" +
            ") " +
            "and (:lastMissionId is null or m.id < :lastMissionId) " +
            "order by m.createdAt asc")
    List<Mission> findAvailableMissionsForUser(
            @Param("userId") Long userId,
            @Param("lastMissionId") Long lastMissionId,
            Pageable pageable
    );

    Page<Mission> findAllByStore(Store store, Pageable pageable);
}
