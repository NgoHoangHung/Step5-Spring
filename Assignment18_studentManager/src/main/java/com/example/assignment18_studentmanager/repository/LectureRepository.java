package com.example.assignment18_studentmanager.repository;

import com.example.assignment18_studentmanager.model.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}
