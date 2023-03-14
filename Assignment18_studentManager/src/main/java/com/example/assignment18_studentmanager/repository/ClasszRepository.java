package com.example.assignment18_studentmanager.repository;

import com.example.assignment18_studentmanager.model.entity.Classz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasszRepository extends JpaRepository<Classz, Integer> {
    boolean existsById(int id);

}
