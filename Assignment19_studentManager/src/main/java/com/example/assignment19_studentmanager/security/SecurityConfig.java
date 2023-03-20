package com.example.assignment19_studentmanager.security;

import com.example.assignment19_studentmanager.model.entity.User;
import com.example.assignment19_studentmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(inMemoryUserDetailsManager())
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
//    http://localhost:8000/users/getall
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
//                .loginPage("/signin")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Bean
    @Primary
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        List<UserDetails> userList = new ArrayList<>();

        Authority authority = new Authority();
        try {
            var list = userRepository.findAll();
            for (User user : list) {
                User tmp = new
                        User();
                tmp.setUsername(user.getUsername());
                tmp.setPassword(user.getPassword());
                tmp.setAuthorities(authority.getAuthority("MEMBER"));
                userList.add(tmp);
            }
        } catch (Exception e) {
            System.out.println("\n lỗi" + e.getMessage());
        }
        return new InMemoryUserDetailsManager(userList);
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
