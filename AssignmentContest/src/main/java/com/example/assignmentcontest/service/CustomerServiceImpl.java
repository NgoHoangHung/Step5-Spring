package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.CustomerDTO;
import com.example.assignmentcontest.model.entity.Customer;
import com.example.assignmentcontest.repository.CustomerRepository;
import com.example.assignmentcontest.repository.ShiperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShiperRepository shiperRepository;

    @Override
    public List<CustomerDTO> getListCustomer() {
        ModelMapper mapper = new ModelMapper();
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public String insertCustomer(CustomerDTO customerDTO) {
        if (!customerRepository.existsByPhone(customerDTO.getPhone())) {
            Customer input = new Customer();
            input.setName(customerDTO.getName());
            input.setPhone(customerDTO.getPhone());
            customerRepository.save(input);
            return "Đã thêm thành công";
        }
        return "Khách hàng đã tồn tại";
    }

    @Override
    public String editCustomer(String phone, Customer customer) {
        if (customerRepository.existsByPhone(phone)) {
            Customer input = customerRepository.findByPhone(phone);
            return "Đã sửa thành công";
        }
        return "Không tồn tại khách hàng";
    }
}
