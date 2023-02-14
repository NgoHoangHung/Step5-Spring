package com.example.kt_jpa.repository;

import com.example.kt_jpa.model.dto.ProductDTO;
import com.example.kt_jpa.model.entities.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OrderrRepository extends JpaRepository<Orderr, Integer> {
}
