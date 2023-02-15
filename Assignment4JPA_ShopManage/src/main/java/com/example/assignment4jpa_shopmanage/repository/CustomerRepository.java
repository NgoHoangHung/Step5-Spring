package com.example.assignment4jpa_shopmanage.repository;

import com.example.assignment4jpa_shopmanage.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByPhone(String phone);
}
