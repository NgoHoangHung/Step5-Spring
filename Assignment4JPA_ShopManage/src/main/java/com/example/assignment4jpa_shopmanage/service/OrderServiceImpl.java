package com.example.assignment4jpa_shopmanage.service;

import com.example.assignment4jpa_shopmanage.model.dto.CustomerDTO;
import com.example.assignment4jpa_shopmanage.model.dto.OrderDTO;
import com.example.assignment4jpa_shopmanage.model.dto.ProductDTO;
import com.example.assignment4jpa_shopmanage.model.entity.Customer;
import com.example.assignment4jpa_shopmanage.model.entity.Order;
import com.example.assignment4jpa_shopmanage.model.entity.Product;
import com.example.assignment4jpa_shopmanage.model.entity.Wallet;
import com.example.assignment4jpa_shopmanage.repository.CustomerRepository;
import com.example.assignment4jpa_shopmanage.repository.OrderRepository;
import com.example.assignment4jpa_shopmanage.repository.ProductRepository;
import com.example.assignment4jpa_shopmanage.repository.WalletRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public String createOrder(OrderDTO dto) {
        Order order = new Order();
        ModelMapper mapper = new ModelMapper();
        //danh sách sản phẩm
//        List<ProductDTO> productDTOS = ;
//        for (ProductDTO productDTO : productDTOS) {
//            Product repo = productRepository.findById(productDTO.getProduct_id()).get();
//            repo.setQuantity(repo.getQuantity() - productDTO.getQuantity());
//            productRepository.save(repo);
//            product.add(repo);
//        }
        List<Product> product = dto.getProductList().stream()
                .map(productDTO -> mapper.map(productDTO, Product.class))
                .collect(Collectors.toList());
        for (Product p : product) {
            Product repo = productRepository.findById(p.getId()).get();
            repo.setQuantity(repo.getQuantity() - p.getQuantity());
            productRepository.save(repo);
        }
        order.setProductList(product);

        //người mua
        CustomerDTO cdto = new CustomerDTO();
        Customer customer = customerRepository.findByPhone(dto.getCustomerDTO().getPhone());

        if (customer != null) {
            customer.getWallet().setBalance(customer.getWallet().getBalance());
            order.setCustomer(customer);
        } else {
            Wallet wallet = new Wallet();
            wallet.setAccountNumber(dto.getCustomerDTO().getWallet().getAccountNumber());
//            wallet.setBalance(dto.getCustomerDTO().getWallet().getBalance());
            walletRepository.save(wallet);

            Customer customerNew = mapper.map(dto.getCustomerDTO(), Customer.class);
            customerNew.setWallet(wallet);
            customerRepository.save(customerNew);
            order.setCustomer(customerNew);
        }
        //trạng thái đơn hàng và giá
        order.setTotalPrice(totalPrice(dto.getProductList()));
        order.setStatus("Chưa thanh toán");

        orderRepository.save(order);
        return "Thêm đơn hàng thành công";
    }

    private double totalPrice(List<ProductDTO> dto) {
        double price = 0;
        for (ProductDTO productDTO : dto) {
            price += productDTO.getPrice() * productDTO.getQuantity();
        }
        return price;
    }
}















