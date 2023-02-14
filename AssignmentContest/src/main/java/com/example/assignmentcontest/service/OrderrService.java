package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.OrderrDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderrService {
    public List<OrderrDTO> getAllOrderr();

    public OrderrDTO getOrderrById(String id);

    public String creatOrderr(OrderrDTO orderr);
}
