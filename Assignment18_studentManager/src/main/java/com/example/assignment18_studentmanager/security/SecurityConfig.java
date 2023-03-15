package com.example.assignment18_studentmanager.security;

import com.example.assignment18_studentmanager.model.entity.CustomUserDetail;
import com.example.assignment18_studentmanager.model.entity.User;
import com.example.assignment18_studentmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(inMemoryUserDetailsManager())
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        List<UserDetails> userDetailList = new ArrayList<>();

        Authority authority = new Authority();
        try{

            var list = userRepository.findAll();
            for (User user : list) {
                CustomUserDetail tmp = new CustomUserDetail();
                tmp.setUser(user);
                tmp.setAuthorities(Arrays.asList(authority.getAuthority(user.getRoll())));
                userDetailList.add(tmp);
            }
        }catch (Exception e){
            System.out.println("\n lỗi" +e.getMessage());
        }
        return new InMemoryUserDetailsManager(userDetailList);
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
