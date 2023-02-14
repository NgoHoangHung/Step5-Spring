package com.example.assignmentcontest.model.dto;

import com.example.assignmentcontest.model.entity.Product;
import com.example.assignmentcontest.model.orther.Status;
import lombok.Data;

import java.util.List;
@Data
public class OrderrDTO {
    private String id;
//    private double total_payment;
//    private Status status;
    private String address;
//    private String estimate_time;
//    private String time_order;
    private CustomerDTO customerDTO;

    private ShipperDTO shipperDTO;

    private List<ProductDTO> productDTOs;


}
