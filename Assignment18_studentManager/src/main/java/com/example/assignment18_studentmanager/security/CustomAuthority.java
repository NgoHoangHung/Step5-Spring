package com.example.assignment18_studentmanager.security;

import com.example.assignment18_studentmanager.model.entity.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table
public class CustomAuthority {
    private List<GrantedAuthority> authorities;

    public CustomAuthority() {
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(String.valueOf(Authority.ADMIN)));
        authorities.add(new SimpleGrantedAuthority(String.valueOf(Authority.TEACHER)));
        authorities.add(new SimpleGrantedAuthority(String.valueOf(Authority.STUDENT)));
        authorities.add(new SimpleGrantedAuthority(String.valueOf(Authority.TELESALE)));
        authorities.add(new SimpleGrantedAuthority(String.valueOf(Authority.MEMBER)));
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public GrantedAuthority getAuthority(String authority) {
        return authorities.stream()
                .filter(a -> a.getAuthority().equals(authority))
                .findFirst()
                .orElse(null);
    }
}
