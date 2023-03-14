package com.example.assignment18_studentmanager.repository;

import com.example.assignment18_studentmanager.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByNameContaining(String name);
}
