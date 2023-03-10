package com.example.security4_book_user.security;

import com.example.security4_book_user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenProvider authenProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // chỗ này em phân vân luồng chạy kiểu gì

        http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("READ")
                .antMatchers("/api/**").hasAnyRole("READ")
                .antMatchers("/api/**").hasAnyRole("READ")
                .antMatchers("/api/**").hasAnyRole("READ")
                .antMatchers("/api/**").hasAnyRole("READ")
                .antMatchers("/api/**").permitAll();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Authority authority = new Authority();


        User user1 = new User("read", "123");
        user1.setAuthorities(Arrays.asList(authority.getAuthority("READ")));
        User user2 = new User("create", "123");
        user2.setAuthorities(Arrays.asList(authority.getAuthority("CREATE")));
        User user3 = new User("delete", "123");
        user3.setAuthorities(Arrays.asList(authority.getAuthority("DELETE")));
        User user4 = new User("edit", "123");
        user4.setAuthorities(Arrays.asList(authority.getAuthority("EDIT")));
        User user5 = new User("search", "123");
        user5.setAuthorities(Arrays.asList(authority.getAuthority("SEARCH")));
        User admin = new User("admin", "123");
        admin.setAuthorities(authority.getAuthorities());
        return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5, admin);
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
