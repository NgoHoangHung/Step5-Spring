package com.example.assignment6studentmanager.service;

import com.example.assignment6studentmanager.model.dto.SubjectDTO;
import com.example.assignment6studentmanager.model.entity.Classz;
import com.example.assignment6studentmanager.model.entity.Subject;
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
