package com.example.assignment6carservice.service;

import com.example.assignment6carservice.model.dto.OrderrDTO;
import com.example.assignment6carservice.model.entity.Customer;
import com.example.assignment6carservice.model.entity.Orderr;
import com.example.assignment6carservice.repository.OrderrRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderrServiceImpl implements OrderrService {
    @Autowired
    private OrderrRepository orderrRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public String insertOrder(OrderrDTO dto) {
        Orderr orderr = new Orderr();
        orderr.setCustomer(mapper.map(dto.getCustomerDTO(), Customer.class));
        odderr.setStaff
        return null;
    }
}
