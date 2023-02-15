package com.example.assignment4jpa_shopmanage.repository;

import com.example.assignment4jpa_shopmanage.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
