package com.example.assignment19_studentmanager.security.service;

import com.example.assignment19_studentmanager.model.dto.UserDTO;
import com.example.assignment19_studentmanager.model.entity.Authority;
import com.example.assignment19_studentmanager.model.entity.User;
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
