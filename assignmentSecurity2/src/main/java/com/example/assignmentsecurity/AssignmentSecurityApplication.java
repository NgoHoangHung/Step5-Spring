package com.example.assignmentsecurity;

import com.example.assignmentsecurity.model.Product;
import com.example.assignmentsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AssignmentSecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentSecurityApplication.class, args);
    }

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
//        Product product1 = new Product();
//        product1.setName("apple");
//        product1.setPrice(150);
//        Product product2 = new Product();
//        product2.setName("mango");
//        product2.setPrice(100);
//        Product product3 = new Product();
//        product3.setName("ringle");
//        product3.setPrice(250);
//        productRepository.saveAll(Arrays.asList(product1, product2, product3));

    }
}
