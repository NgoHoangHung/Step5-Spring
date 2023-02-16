package com.example.assignment6studentmanager.repository;

import com.example.assignment6studentmanager.model.entity.Student;
import com.example.assignment6studentmanager.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
