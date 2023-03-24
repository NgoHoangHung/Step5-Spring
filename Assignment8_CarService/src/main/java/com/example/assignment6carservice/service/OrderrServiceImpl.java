package com.example.assignment6carservice.service;

import com.example.assignment6carservice.exception.NotFoundExcepton;
import com.example.assignment6carservice.model.dto.CustomerDTO;
import com.example.assignment6carservice.model.dto.OrderrDTO;
import com.example.assignment6carservice.model.entity.*;
import com.example.assignment6carservice.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderrServiceImpl implements OrderrService {
    @Autowired
    private OrderrRepository orderrRepository;
    ModelMapper mapper = new ModelMapper();
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public OrderrDTO getById(int id) {
        return mapper.map(orderrRepository.findById(id).get(), OrderrDTO.class);
    }

    @Override
    public List<OrderrDTO> getAll() {
        return orderrRepository.findAll().stream()
                .map(orderr -> mapper.map(orderr, OrderrDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public String insertOrder(OrderrDTO dto) {
//        if (orderrRepository.existsById(dto.getId()))
//            throw new NotFoundExcepton("Order existed!");
        Orderr orderr = new Orderr();
        CustomerDTO customerDTO = dto.getCustomerDTO();
        if (!customerRepository.existsByPhone(customerDTO.getPhone())) {
            Customer customer = new Customer();
            customer.setNameCustomer(customerDTO.getNameCustomer());
            customer.setAddress(customerDTO.getAddress());
            customer.setPhone(customerDTO.getPhone());
            customer.setWallet(customerDTO.getWallet());
            customerRepository.save(customer);
            orderr.setCustomer(customer);
        } else {
            orderr.setCustomer(mapper.map(dto.getCustomerDTO(), Customer.class));
        }


        Date currentDate = new Date(System.currentTimeMillis());
        System.out.println("Current: " + currentDate);
        orderr.setTime_order(currentDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 7);
        currentDate = calendar.getTime();
        System.out.println("Estimate: " + currentDate);
        orderr.setTime_estimate(currentDate);
        orderr.setStatus(dto.getStatus());
        orderr.setNote(dto.getNote());

        Set<Service> services = dto.getServicesDTO().stream()
                .map(serviceDTO -> mapper.map(serviceDTO, Service.class))
                .collect(Collectors.toSet());

        for (Service service : services) {
            service.setOrderr(orderr);
        }

//        Set<Staff> staffs = dto.getStaffsDTO().stream()
//                .map(staffDTO -> mapper.map(staffDTO, Staff.class))
//                .collect(Collectors.toSet());
//        for (Staff staff : staffs) {
//            staff.setOrderrs(orderr);
//        }


        Set<Product> products = dto.getProductsDTO().stream()
                .map(productDTO -> mapper.map(productDTO, Product.class))
                .collect(Collectors.toSet());
        for (Product product : products) {
            product.setOrderr(orderr);
        }

        orderr.setProducts(products);

        orderr.setServices(services);

        orderr.setNote(dto.getNote());
        orderr.setStatus(dto.getStatus());

        orderr.setTotal_price(total(services));

//        orderr.setStaffs(staffs);
        productRepository.saveAll(products);
        serviceRepository.saveAll(services);
//        staffRepository.saveAll(staffs);
        orderrRepository.save(orderr);
        return "đã thêm thành công!";
    }

    public double total(Set<Service> services) {
        double resul = 0;
        for (Service service : services) {
            resul += service.getFee();
        }
        return resul;
    }

    @Override
    public String updateOrderr(OrderrDTO dto) {
        return null;
    }
}
