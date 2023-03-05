package com.example.assignmentsecurity.controller;

import com.example.assignmentsecurity.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @GetMapping("/products")
    public List<Product> getAll() {
        List<Product> products = new ArrayList();
        products.add(new Product("apple", 150));
        products.add(new Product("mango", 100));
        products.add(new Product("ringle", 250));
        return products;
    }

    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/hello").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/login")
                    .permitAll();
        }
    }

}