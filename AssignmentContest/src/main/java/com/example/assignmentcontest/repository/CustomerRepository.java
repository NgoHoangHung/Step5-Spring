package com.example.assignmentcontest.repository;

import com.example.assignmentcontest.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByPhone(String phoneNumber);

    boolean existsByPhone(String phonenumber);
}
