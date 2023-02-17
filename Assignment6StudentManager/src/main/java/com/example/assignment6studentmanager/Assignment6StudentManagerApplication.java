package com.example.assignment6studentmanager;

import com.example.assignment6studentmanager.repository.ClasszRepository;
import com.example.assignment6studentmanager.repository.LectureRepository;
import com.example.assignment6studentmanager.repository.StudentRepository;
import com.example.assignment6studentmanager.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment6StudentManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assignment6StudentManagerApplication.class, args);
    }

    @Autowired
    private ClasszRepository classzRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
