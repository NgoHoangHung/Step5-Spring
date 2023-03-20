package com.example.assignment19_studentmanager.security.service;

import com.example.assignment19_studentmanager.model.dto.UserDTO;
import com.example.assignment19_studentmanager.model.entity.Authority;
import com.example.assignment19_studentmanager.model.entity.User;
import com.example.assignment19_studentmanager.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public User findClassById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public String createUser(UserDTO user) {
        if (userRepository.existsByPhone(user.getPhone()))
            return "Học sinh đã tồn tại. vui lòng thêm học sinh khác";
        Authority authority = new Authority();
        User input = User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .phone(user.getPhone())
                .email(user.getEmail())
                .authorities(authority.getAuthority("MEMBER"))
                .build();
        userRepository.save(input);
        return "đã thêm mới một học sinh";
    }

    @Override
    public String updateUser(UserDTO dto, Authority authority) {
        return null;
    }


    @Override
    public String deleteUser(int id) {
        if (!userRepository.existsById(id)) return "học sinh không tồn tại";
        userRepository.deleteById(id);
        return "đã xóa thành công";
    }
}
