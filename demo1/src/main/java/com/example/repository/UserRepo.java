package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUserNameAndStatus(String userName, Integer status);

    Optional<User> findByMobileAndStatus(String userName, Integer status);
    Optional<User> findByEmailAndStatus(String userName, Integer status);
    Optional<User> findById(Integer id);
    List<User> findByStatus(Integer status);
}
