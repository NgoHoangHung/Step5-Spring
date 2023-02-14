package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.ProductDTO;
import com.example.assignmentcontest.model.dto.ShipperDTO;
import com.example.assignmentcontest.model.entity.Shipper;
import com.example.assignmentcontest.model.entity.Vote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipperService {
    public List<ShipperDTO> getListShipperDTO();

    public String insertShipper(ShipperDTO shipperDTO);

    public String editShipper(String phone, Shipper shipper);

    double getBunus(ProductDTO product, Vote vote);

    public double getShipPrice(double weight);
}
