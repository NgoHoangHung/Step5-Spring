package com.example.assignment6studentmanager.repository;

import com.example.assignment6studentmanager.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByNameContaining(String name);
}
