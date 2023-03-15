package com.example.demo1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashMap;
import java.util.Map;
/*một trang web được bảo mật thì cũng sẽ có 2 phương thức cốt lõi  để cấu hình cho nó mà thôi
* ta sẽ sử dụng @EnableWebSecurity để đánh dấu đây là class cấu hình cho việc bảo mật
* ta kế thừa class WebSecurityConfigurerAdapter nhằm xây dựng lên hai phương thức
* configure(HttpSecurity http) và configure(AuthenticationManagerBuilder auth)
*
* */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenProvider authenProvider;
    //sử dụng bean này để truyền authentication vào trong AuthenticationManagerBuilder

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder()::encode);
        UserDetails user1 = userBuilder.username("hung1").password("123").roles(Role.USER).build();
        UserDetails user2 = userBuilder.username("hung2").password("123").roles(Role.USER).build();
        UserDetails user3 = userBuilder.username("operator").password("123").roles(Role.OPERATOR).build();
        UserDetails user4 = userBuilder.username("admin").password("123").roles(Role.ADMIN).build();
        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }

    @Bean
    public PasswordEncoder encoder() {
        return delegatingPasswordEncoder("bcrypt");
    }

    public PasswordEncoder delegatingPasswordEncoder(String encodeType) {
        Map<String, PasswordEncoder> encoder = new HashMap<>();
        encoder.put("bcrypt", new BCryptPasswordEncoder());
        encoder.put("scrypt", new SCryptPasswordEncoder());
        encoder.put("pbkdf2", new Pbkdf2PasswordEncoder());
        return new DelegatingPasswordEncoder(encodeType, encoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/api/products").hasAnyRole(Role.ADMIN)
                .antMatchers("/api/test1").hasAnyRole(Role.ADMIN, Role.USER)
                .antMatchers("/api/test2").hasAnyRole(Role.ADMIN, Role.OPERATOR)
                .antMatchers("/api/test3").hasAnyRole(Role.ADMIN, Role.OPERATOR, Role.USER)
                .antMatchers("/api/**").permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenProvider);
    }
}
