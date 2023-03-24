package com.example.kt_jpa.service;

import com.example.kt_jpa.model.dto.OrderrDTO;
import com.example.kt_jpa.model.dto.ProductDTO;
import com.example.kt_jpa.model.entities.*;
import com.example.kt_jpa.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderrServiceImpl implements OrderrService {
    @Autowired
    private OrderrRepository orderrRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    @Override
    public String createOrder(OrderrDTO dto) {
        Orderr orderr = new Orderr();
        ModelMapper mapper = new ModelMapper();

        Shiper shiper = shipperRepository.findById(dto.getShipperId()).orElse(null);
        if (shiper == null) {
            return "Not found shipper with id: " + dto.getShipperId();
        }

        Customer customer = customerRepository.findByPhone(dto.getCustomer().getPhone());
        if (customer != null) {
            double shipPrice = totalPrice(dto.getProducts());
            double balance = customer.getWallet().getBalance();
            if (balance > shipPrice) {
                customer.getWallet().setBalance(customer.getWallet().getBalance() - shipPrice);
                orderr.setCustomer(customer);
            } else {
                // linh động bảo khách nạp thêm 50k
                double chargeMoney = 50000;
                customer.getWallet().setBalance(balance + chargeMoney - shipPrice);
                orderr.setCustomer(customer);
            }

        } else {
            Wallet wallet = new Wallet();
            wallet.setAccountNumber(dto.getCustomer().getWallet().getAccountNumber());
            wallet.setBalance(dto.getCustomer().getWallet().getBalance());
            walletRepository.save(wallet);

            Customer customerNew = mapper.map(dto.getCustomer(), Customer.class);
            customerNew.setWallet(wallet);
            customerRepository.save(customerNew);
            orderr.setCustomer(customerNew);
        }
        orderr.setAddress(dto.getAddress());
        orderr.setStatus("Waiting processing...");

        Date currentDate = new Date(System.currentTimeMillis());
        System.out.println("Current: " + currentDate);
        orderr.setTimeOrder(currentDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 7);
        currentDate = calendar.getTime();
        System.out.println("Estimate: " + currentDate);
        orderr.setEstimateTime(currentDate);

        orderr.setShiper(shiper);
        orderr.setPrice(totalPrice(dto.getProducts()));


        Set<Product> products = dto.getProducts().stream()
                .map(productDTO -> mapper.map(productDTO, Product.class))
                .collect(Collectors.toSet());
        for (Product p : products) {
            p.setOrderr(orderr);
        }
        orderr.setProducts(products);
        productRepository.saveAll(products);
        orderrRepository.save(orderr);

        return "Đơn hàng đã khởi tạo thành công";
    }

    @Override
    public String isSuccessOrder(int id) {
        Orderr orderr = orderrRepository.findById(id).get();
        orderr.setStatus("success");
        Shiper shiper = orderr.getShiper();
        shiper.getWallet().setBalance(shiper.getWallet().getBalance() + orderr.getPrice() * 0.1);
        orderr.setPrice(orderr.getPrice() * 0.9);
        orderrRepository.save(orderr);
        shipperRepository.save(shiper);
        return "giao hàng thành công";
    }

    private double totalPrice(Set<ProductDTO> products) {

        // Cách 1
        /*
        double weight =0;
        for (Product p: products) {
            weight+= p.getWeight();
        }*/
        // Cách 2: sử dụng stream
        double weight = products.stream().mapToDouble(ProductDTO::getWeight).sum();
        return weight <= 10 ? 15000.0 : weight <= 20 ? 20000.0 : 30000.0;
    }
}
