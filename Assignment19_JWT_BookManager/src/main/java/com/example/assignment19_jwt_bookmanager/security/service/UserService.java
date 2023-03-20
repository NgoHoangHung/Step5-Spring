package com.example.assignment19_jwt_bookmanager.security.service;

import com.example.assignment19_jwt_bookmanager.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();

    User getById(int id);

    String create(User object);

    String delete(int id);

    String edit(int id, User user);


    List<?> search(String key);
}
