package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.UserDTO;
import com.example.assignment18_studentmanager.model.entity.CustomUserDetail;
import com.example.assignment18_studentmanager.model.entity.User;
import com.example.assignment18_studentmanager.repository.ClasszRepository;
import com.example.assignment18_studentmanager.repository.UserRepository;
import com.example.assignment18_studentmanager.security.Authority;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClasszRepository classzRepository;
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
        CustomUserDetail userDetail = new CustomUserDetail();
        Authority authority = new Authority();
        User input = new User();
        input.setName(user.getName());
        input.setPhone(user.getPhone());
        input.setEmail(user.getEmail());
        input.setPassword(user.getPassword());
        userRepository.save(input);
        userDetail.setUser(input);
        userDetail.setAuthorities(Arrays.asList(authority.getAuthority("MEMBER")));
        return "đã thêm mới một học sinh";
    }

    @Override
    public String updateUser(UserDTO dto,Authority authority) {
        return null;
    }

    @Override
    public String deleteUser(int id) {
        if (!userRepository.existsById(id)) return "học sinh không tồn tại";
        userRepository.deleteById(id);
        return "đã xóa thành công";
    }
}
