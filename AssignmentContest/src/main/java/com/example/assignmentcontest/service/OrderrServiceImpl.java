package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.CustomerDTO;
import com.example.assignmentcontest.model.dto.OrderrDTO;
import com.example.assignmentcontest.model.dto.ProductDTO;
import com.example.assignmentcontest.model.dto.ShipperDTO;
import com.example.assignmentcontest.model.entity.Orderr;
import com.example.assignmentcontest.model.entity.Shipper;
import com.example.assignmentcontest.model.orther.Status;
import com.example.assignmentcontest.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderrServiceImpl implements OrderrService {
    @Autowired
    private OrderrRepository orderrRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShipperService shipperService;
    /*
        bước 1: hệ thống tiến hành ghi thông tin vào Orderr khi có nguời gửi hàng.
        bước 2: ta tiến hành thêm các thông tin vào trường Orderr.
     */


    @Override
    public List<OrderrDTO> getAllOrderr() {
        ModelMapper mapper = new ModelMapper();
        List<Orderr> orderrs = orderrRepository.findAll();
        return orderrs.stream().map(orderr -> mapper.map(orderr, OrderrDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderrDTO getOrderrById(String id) {
        ModelMapper mapper = new ModelMapper();
        Orderr orderr = orderrRepository.findById(id).get();
        return mapper.map(orderr, OrderrDTO.class);
    }

    @Override
    public String creatOrderr(OrderrDTO orderrDTO) {
        if (orderrDTO == null) return "đơn hàng chưa được khởi tạo";
        Orderr input = new Orderr();
        double product_price = 0;
        double shipper_price = 0;
        double product_weight = 0;
        // chương trình bắt thời gian thực khi hàm được khởi tạo
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date creatAt = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(creatAt);
        calendar.add(Calendar.DATE, 2);
        Date twoDaysLater = calendar.getTime();

        input.setStatus(Status.NOT_SUCESS);
        input.setAddress(orderrDTO.getAddress());

        input.setEstimate_time(dateFormat.format(twoDaysLater));
        input.setTime_order(dateFormat.format(creatAt));
        CustomerDTO customerDTO = orderrDTO.getCustomerDTO();
        List<ProductDTO> products = orderrDTO.getProductDTOs();
        //lấy giá trị đơn hàng
        for (ProductDTO productDTO : products) {
            product_price += productService.getPrice(productDTO);
            product_weight += productService.getWeight(productDTO);
        }
        input.setTotal_payment(product_price + shipperService.getShipPrice(product_weight));
        input.setShipPrice(shipperService.getShipPrice(product_weight));

//        Shipper shipper = shiperRepository.findByPhone(shipperDTO.getPhone());
//        shipper.getOderrs().add()

        return "Đã tạo đơn hàng thành công";
    }


}
