package com.example.assignmentsecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //ví dụ1:
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var user1 = User.withUsername("tientho").password("123").authorities("read").build();
//        var user2 = User.withUsername("thotien").password("123456").authorities("read").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    //        @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//---------------------------------------------------------------------------------------------
    //ví dụ2
    /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic(); //có thể thay thế bằng http.formLogin();
        http.authorizeRequests().anyRequest().authenticated();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hungnh")
                .password("123")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/


    //---------------------------------------------------------------------------------------------
    //ví dụ3
    /*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager())
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Collection<UserDetails> users = new ArrayList<>();
        var hung1 = User.withUsername("hung1").password("123").authorities("read").build();
        var hung2 = User.withUsername("hung2").password("123").authorities("read").build();
        var hung3 = User.withUsername("hung3").password("123").authorities("read").build();
        users.add(hung1);
        users.add(hung2);
        users.add(hung3);
        return new InMemoryUserDetailsManager(users);
    }
    */
// --------------------------------------------------------------------------------------------
//ví dụ 4
    /*      @Autowired
      private PasswordEncoder encoder;

      @Override
      protected void configure(HttpSecurity http) throws Exception {
          http.httpBasic();
          http.authorizeRequests().anyRequest().authenticated();
      }

      @Bean
      public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
      }

      @Bean
      public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
          Collection<UserDetails> users = new ArrayList<>();
          User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
          var hung1 = userBuilder.username("hung1").password("123").roles("USER").build();
          var hung2 = userBuilder.username("hung2").password("123").roles("USER").build();
          var hung3 = userBuilder.username("hung3").password("123").roles("USER").build();
          System.out.println("this is pass" + hung1.getPassword());
          users.add(hung1);
          users.add(hung2);
          users.add(hung3);
          return new InMemoryUserDetailsManager(users);
      }*/
//----------------------------------------------------------
    //ví dụ 5
    @Autowired
    private PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }

    public static PasswordEncoder delegatePasswordEnCoder(String encodingType) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("bcrypt", new SCryptPasswordEncoder());

        encoders.put("ldap", new LdapShaPasswordEncoder());
        encoders.put("MD4", new Md4PasswordEncoder());
        encoders.put("MD5", new MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop",  NoOpPasswordEncoder.getInstance());
        encoders.put("SHA-1", new MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256", new MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new StandardPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingType, encoders);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return SecurityConfig.delegatePasswordEnCoder("pbkdf2");
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Collection<UserDetails> users = new ArrayList<>();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
        var hung1 = userBuilder.username("hung1").password("123").roles("USER").build();
        var hung2 = userBuilder.username("hung2").password("123").roles("USER").build();
        var hung3 = userBuilder.username("hung3").password("123").roles("USER").build();
        System.out.println("this is pass" + hung1.getPassword());
        users.add(hung1);
        users.add(hung2);
        users.add(hung3);
        return new InMemoryUserDetailsManager(users);
    }
}
