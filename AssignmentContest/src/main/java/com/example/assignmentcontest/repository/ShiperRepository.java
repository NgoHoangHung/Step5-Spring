package com.example.assignmentcontest.repository;

import com.example.assignmentcontest.model.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiperRepository extends JpaRepository<Shipper, String> {
    Shipper findByPhone(String phoneNumber);

    boolean existsByPhone(String phone);
}

