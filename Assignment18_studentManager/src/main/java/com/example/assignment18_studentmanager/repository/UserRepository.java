package com.example.assignment18_studentmanager.repository;

import com.example.assignment18_studentmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    boolean existsByPhone(String phone);
}
