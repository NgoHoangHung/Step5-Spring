package com.example.assignmentcontest.control;

import com.example.assignmentcontest.model.dto.ShipperDTO;
import com.example.assignmentcontest.model.entity.Shipper;
import com.example.assignmentcontest.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping("/getAll")
    public List<ShipperDTO> getListShipperDTO() {
        return shipperService.getListShipperDTO();
    }

    @PostMapping("/insert")
    public String insertShipper(@RequestBody ShipperDTO shipperDTO) {
        return shipperService.insertShipper(shipperDTO);
    }

    @PutMapping("/edit")
    public String editShipper(String phone, Shipper shipper) {
        return shipperService.editShipper(phone, shipper);
    }
}
