package com.example.assignment19_jwt_bookmanager.security.service;

import com.example.assignment19_jwt_bookmanager.model.entity.User;
import com.example.assignment19_jwt_bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Kiểm tra user có tồn tại trong database hay không
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + "không tồn tại");
        }
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UsernameNotFoundException("không tồn tại user với id:" +id );
        }
        return new CustomUserDetails(user);
    }
}
