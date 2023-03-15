package com.example.assignment18_studentmanager.repository;

import com.example.assignment18_studentmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByPhone(String phone);
}
