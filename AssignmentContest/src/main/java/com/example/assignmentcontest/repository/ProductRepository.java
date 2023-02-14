package com.example.assignmentcontest.repository;

import com.example.assignmentcontest.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
