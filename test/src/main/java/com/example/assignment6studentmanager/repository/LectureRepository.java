package com.example.assignment6studentmanager.repository;

import com.example.assignment6studentmanager.model.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}
