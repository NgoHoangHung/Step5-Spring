package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.UserDTO;
import com.example.assignment18_studentmanager.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findClassById(int id);

    List<User> findAll();

    String createUser(User dto);

    String updateStudent(UserDTO dto);

    String deleteStudent(int id);
}
