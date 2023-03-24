package com.example.assignment6carservice.service;

import com.example.assignment6carservice.model.dto.OrderrDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderrService {
    OrderrDTO getById(int id);

    List<OrderrDTO> getAll();

    String insertOrder(OrderrDTO dto);

    String updateOrderr(OrderrDTO dto);
}
