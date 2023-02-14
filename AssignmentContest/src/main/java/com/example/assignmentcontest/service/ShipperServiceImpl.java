package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.ProductDTO;
import com.example.assignmentcontest.model.dto.ShipperDTO;
import com.example.assignmentcontest.model.entity.Shipper;
import com.example.assignmentcontest.model.entity.Vote;
import com.example.assignmentcontest.repository.ShiperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShipperServiceImpl implements ShipperService {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShiperRepository shiperRepository;


    @Override
    public List<ShipperDTO> getListShipperDTO() {
        ModelMapper mapper = new ModelMapper();
        List<Shipper> shippers = shiperRepository.findAll();
        return shippers.stream()
                .map(shipper -> mapper.map(shipper, ShipperDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public String insertShipper(ShipperDTO shipperDTO) {
        if (!shiperRepository.existsByPhone(shipperDTO.getPhone())) {
            Shipper input = new Shipper();
            input.setName(shipperDTO.getName());
            input.setPhone(shipperDTO.getPhone());
            shiperRepository.save(input);
            return "Thêm shipper thành công";
        }
        return "Shipper đã tồn tại";
    }

    @Override
    public String editShipper(String phone, Shipper shipper) {
        if (!shiperRepository.existsByPhone(phone)) {
            Shipper input = shiperRepository.findByPhone(phone);
            input.setName(shipper.getName());
            input.setPhone(shipper.getPhone());
            input.setOderrs(shipper.getOderrs());
            input.setWallet(shipper.getWallet());
            shiperRepository.save(input);
            return "thay đổi thành công";
        }
        return "Không tồn tại shipper";
    }


    @Override
    public double getBunus(ProductDTO product, Vote vote) {
        if (vote.getRate() < 3) {
            return productService.getPrice(product) * 0.5;
        } else if (vote.getRate() >= 3 && vote.getRate() <= 5) {
            return productService.getPrice(product);
        }
        return 0;
    }

    @Override
    public double getShipPrice(double weight) {
        if (weight <= 10.0) return 15000.0;
        else if (weight > 10.0 && weight <= 20.0) return 20000.0;
        else if (weight >= 20.0) return 30000.0;
        else return 0;
    }
}
