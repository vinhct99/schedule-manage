package com.example.repository;


import com.example.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
    List<Schedule> findByCreatedByAndIsVisibleAndIsDeletedAndAndIsPublic (String userName, Integer isV, Integer isD,Integer isP);
    Optional<Schedule> findById (Integer id);
    List<Schedule> findByIsPublicAndIsDeletedAndAndIsVisible(Integer isP, Integer isD, Integer isV);
    List<Schedule> findByIsPublicAndIsDeletedAndAndIsVisibleAndDeptId(Integer isP, Integer isD, Integer isV, Integer departId);
    List<Schedule> findByIsDeletedAndAndIsVisibleAndDeptId( Integer isD, Integer isV, Integer departId);
}
