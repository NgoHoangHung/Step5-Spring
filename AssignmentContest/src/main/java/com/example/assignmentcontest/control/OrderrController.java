package com.example.assignmentcontest.control;

import com.example.assignmentcontest.model.dto.OrderrDTO;
import com.example.assignmentcontest.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orderr")
public class OrderrController {
    @Autowired
    private OrderrService orderrService;

    @GetMapping("/getAll")

    public List<OrderrDTO> getAllOrderr() {
        return orderrService.getAllOrderr();
    }

    @PostMapping("/createOrderr")
    public String createOrderr(@RequestBody OrderrDTO orderrDTO) {
        return orderrService.creatOrderr(orderrDTO);
    }

}
