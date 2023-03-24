package com.example.kt_jpa.service;

import com.example.kt_jpa.model.entities.Orderr;
import com.example.kt_jpa.repository.OrderrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShipperServiceImpl implements ShipperService {
    @Autowired
    private OrderrRepository orderrRepository;

    @Override
    public String update(int id) {
        Orderr input = orderrRepository.findById(id).get();
        input.setStatus("đã giao");
        return null;
    }
}
