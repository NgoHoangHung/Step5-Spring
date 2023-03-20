package com.example.assignment19_jwt_bookmanager.security.service;

import com.example.assignment19_jwt_bookmanager.model.entity.Authority;
import com.example.assignment19_jwt_bookmanager.model.entity.User;
import com.example.assignment19_jwt_bookmanager.repository.AuthorityRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomUserDetails implements UserDetails {
    User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Autowired
    private AuthorityRepository authorityRepository;
    List<Authority> authorityList = authorityRepository.findAll();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
