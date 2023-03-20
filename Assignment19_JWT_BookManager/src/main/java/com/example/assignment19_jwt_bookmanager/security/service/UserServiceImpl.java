package com.example.assignment19_jwt_bookmanager.security.service;

import com.example.assignment19_jwt_bookmanager.model.entity.User;
import com.example.assignment19_jwt_bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public String create(User object) {
        if(object!=null&&!userRepository.existsById(object.getId()))
        userRepository.save(object);
            return "thêm thành công";
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public String edit(int id, User user) {
        return null;
    }


    @Override
    public List<?> search(String key) {
        return null;
    }
}
