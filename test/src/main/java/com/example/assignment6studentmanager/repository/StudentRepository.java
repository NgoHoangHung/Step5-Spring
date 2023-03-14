package com.example.assignment6studentmanager.repository;

import com.example.assignment6studentmanager.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByPhone(String phone);
}
