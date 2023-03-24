package com.example.assgnement1techmaster.repository;

import com.example.assgnement1techmaster.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
