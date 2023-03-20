package com.example.assignment19_studentmanager.repository;

import com.example.assignment19_studentmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByPhone(String phone);

    User findByUsername(String username);
}
