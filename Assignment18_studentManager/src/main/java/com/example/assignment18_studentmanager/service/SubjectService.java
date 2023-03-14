package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.SubjectDTO;
import com.example.assignment18_studentmanager.model.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SubjectService {
    Subject findSubjectById(int id);


    List<SubjectDTO> findAll();

    String createSubject(SubjectDTO dto);

    String updateSubject(SubjectDTO dto);

    String deleteSubject(int id);
}
