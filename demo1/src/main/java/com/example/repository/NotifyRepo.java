package com.example.repository;

import com.example.entity.Notify;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotifyRepo extends JpaRepository<Notify,Integer> {
    List<Notify> findByIsDeleted (Integer isD);
    List<Notify> findByIsDeletedAndUserId(Integer isD, Integer Id);
}
