package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.CustomerDTO;
import com.example.assignmentcontest.model.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<CustomerDTO> getListCustomer();

    public String insertCustomer(CustomerDTO customerDTO);

    public String editCustomer(String phone, Customer customer);
}
