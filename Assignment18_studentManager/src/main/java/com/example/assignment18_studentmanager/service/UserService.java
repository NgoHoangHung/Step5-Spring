package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.UserDTO;
import com.example.assignment18_studentmanager.model.entity.User;
import com.example.assignment18_studentmanager.security.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findClassById(int id);

    List<User> findAll();

    String createUser(UserDTO dto);

    String updateUser(UserDTO dto, Authority authority);

    String deleteUser(int id);
}
