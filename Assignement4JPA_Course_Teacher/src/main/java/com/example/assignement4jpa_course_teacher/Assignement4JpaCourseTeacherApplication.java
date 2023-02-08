package com.example.assignement4jpa_course_teacher;

import com.example.assignement4jpa_course_teacher.model.entity.Course;
import com.example.assignement4jpa_course_teacher.model.entity.Status;
import com.example.assignement4jpa_course_teacher.model.entity.Student;
import com.example.assignement4jpa_course_teacher.repository.CourseRepository;
import com.example.assignement4jpa_course_teacher.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class Assignement4JpaCourseTeacherApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assignement4JpaCourseTeacherApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student = new Student();
//        student.setNameStudent("hungnh");
//        student.setStatus(Status.Offline);
//        student.setIdentification("033111222333");
//        student.setPhone("032 1234 567");
//        student.setEmail("xxx@gmail.com");
//        student.setAvartar("ss.uu");
//        studentRepository.save(student);
//
//        Student student1 = new Student();
//        student1.setNameStudent("nambh");
//        student1.setStatus(Status.Offline);
//        student1.setIdentification("033111222333");
//        student1.setPhone("032 1234 567");
//        student1.setEmail("xxx@gmail.com");
//        student1.setAvartar("ss.uu");
//        studentRepository.save(student1);
//
//        Student student2 = new Student();
//        student2.setNameStudent("thaipq");
//        student2.setStatus(Status.Offline);
//        student2.setIdentification("033111222333");
//        student2.setPhone("032 1234 567");
//        student2.setEmail("xxx@gmail.com");
//        student2.setAvartar("ss.uu");
//        studentRepository.save(student2);
//
//        Student student3 = new Student();
//        student3.setNameStudent("tiendq");
//        student3.setStatus(Status.Offline);
//        student3.setIdentification("033111222333");
//        student3.setPhone("032 1234 567");
//        student3.setEmail("xxx@gmail.com");
//        student3.setAvartar("ss.uu");
//        studentRepository.save(student3);
//
//        Course course = new Course();
//        course.setNameCourse("Java fullstack");
//        course.setNumberOfLectures(70);
//        course.setPrice(1000);
//        course.setCode("java14");
//        course.setCreatAt("2022/08/01");
//        course.setStudents(Set.of(student, student1, student2, student3));
//        courseRepository.save(course);
//
//        Course course1 = new Course();
//        course1.setNameCourse("frondend");
//        course1.setNumberOfLectures(48);
//        course1.setPrice(700);
//        course1.setCode("web29");
//        course1.setCreatAt("2022/09/01");
//        course1.setStudents(Set.of(student3, student));
//        courseRepository.save(course1);
//
//        Course course2 = new Course();
//        course2.setNameCourse("PHP fullstack");
//        course2.setNumberOfLectures(60);
//        course2.setPrice(900);
//        course2.setCode("PHP4");
//        course2.setCreatAt("2023/02/01");
//        course2.setStudents(Set.of(student1, student2));
//        courseRepository.save(course2);
    }
}
