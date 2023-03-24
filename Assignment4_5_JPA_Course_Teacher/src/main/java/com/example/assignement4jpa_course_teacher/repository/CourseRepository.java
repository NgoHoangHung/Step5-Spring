package com.example.assignement4jpa_course_teacher.repository;

import com.example.assignement4jpa_course_teacher.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
