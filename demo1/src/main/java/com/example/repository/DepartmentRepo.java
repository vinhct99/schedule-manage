package com.example.repository;

import com.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    Optional<Department> findById(Integer id);
    List<Department> findByIdIn(List<Integer> ids);
    List<Department> findByIsDeleted (Integer isD);
    List<Department> findByIsDeletedAndUserId(Integer isD, Integer Id);
}
