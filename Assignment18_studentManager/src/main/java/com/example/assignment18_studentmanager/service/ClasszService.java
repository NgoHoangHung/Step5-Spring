package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.ClasszDTO;
import com.example.assignment18_studentmanager.model.entity.Classz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClasszService {
    Classz findClassById(int id);

    List<ClasszDTO> findAll();

    String createClassz(ClasszDTO dto);

    String updateClassz(ClasszDTO dto);

    String deleteClassz(int id);
}
