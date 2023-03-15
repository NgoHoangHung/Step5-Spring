package com.example.assignment18_studentmanager.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class Authority {
    private List<GrantedAuthority> authorities;


    public Authority() {
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        authorities.add(new SimpleGrantedAuthority("TEACHER"));
        authorities.add(new SimpleGrantedAuthority("STUDENT"));
        authorities.add(new SimpleGrantedAuthority("TELESALE"));
        authorities.add(new SimpleGrantedAuthority("MEMBER"));
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
