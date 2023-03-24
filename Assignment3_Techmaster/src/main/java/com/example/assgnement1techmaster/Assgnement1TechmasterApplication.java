package com.example.assgnement1techmaster;

import com.example.assgnement1techmaster.model.entity.Clasz;
import com.example.assgnement1techmaster.model.entity.Student;
import com.example.assgnement1techmaster.repository.ClaszRepositpory;
import com.example.assgnement1techmaster.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Assgnement1TechmasterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assgnement1TechmasterApplication.class, args);
    }

    @Autowired
    private ClaszRepositpory claszRepositpory;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Clasz java14 = new Clasz();
//        java14.setAddress("Nguyen Dinh Chieu");
//        claszRepositpory.save(java14);
//
//        Student s1 = new Student("hungnh", 30, "good", java14);
//        Student s2 = new Student("thaipq", 26, "good", java14);
//        Student s3 = new Student("trungna", 25, "very good", java14);
//        Student s4 = new Student("tiendq", 23, "good", java14);
//        Student s5 = new Student("nambh", 22, "good", java14);
//        Student s6 = new Student("longnm", 25, "very good", java14);
//        Student s7 = new Student("binhnh", 26, "very good", java14);
//        studentRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7));
    }
}
