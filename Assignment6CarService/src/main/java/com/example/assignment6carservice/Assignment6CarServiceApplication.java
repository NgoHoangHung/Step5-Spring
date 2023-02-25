package com.example.assignment6carservice;

import com.example.assignment6carservice.model.entity.*;
import com.example.assignment6carservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class Assignment6CarServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assignment6CarServiceApplication.class, args);
    }

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Wallet cWallet1 = new Wallet();
        cWallet1.setBalance(5000000.0);
        cWallet1.setAccount_num("111222333");

        Wallet cWallet2 = new Wallet();
        cWallet2.setBalance(600000.0);
        cWallet2.setAccount_num("11223344");

        Wallet cWallet3 = new Wallet();
        cWallet3.setBalance(7000000.0);
        cWallet3.setAccount_num("121212212");
        Wallet sWallet4 = new Wallet();
        sWallet4.setBalance(500000.0);
        sWallet4.setAccount_num("121212212");
        Wallet sWallet5 = new Wallet();
        sWallet5.setBalance(500000.0);
        sWallet5.setAccount_num("222111333");
        Wallet sWallet6 = new Wallet();
        sWallet6.setBalance(500000.0);
        sWallet6.setAccount_num("223335556");
        walletRepository.saveAll(Set.of(cWallet1, cWallet2, cWallet3, sWallet4, sWallet5, sWallet6));

        Customer customer1 = new Customer();
        customer1.setNameCustomer("hungnh");
        customer1.setPhone("0333444555");
        customer1.setAddress("Long bien");
        customer1.setWallet(cWallet1);

        Customer customer2 = new Customer();
        customer2.setNameCustomer("thaipq");
        customer2.setPhone("0123456789");
        customer2.setAddress("to huu");
        customer2.setWallet(cWallet2);

        Customer customer3 = new Customer();
        customer3.setNameCustomer("tiendq");
        customer3.setPhone("0987654321");
        customer3.setAddress("mai dong");
        customer3.setWallet(cWallet3);

//        Staff staff1 = new Staff();
//        staff1.setName("trunganh");
//        staff1.setPhone("0999888999");
//        staff1.setWallet(sWallet4);
//
//        Staff staff2 = new Staff();
//        staff2.setName("thanhhh");
//        staff2.setPhone("0888777888");
//        staff2.setWallet(sWallet5);
//
//        Staff staff3 = new Staff();
//        staff3.setName("thuyjj");
//        staff3.setPhone("0999888999");
//        staff3.setWallet(sWallet6);
//        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
//        staffRepository.saveAll(Arrays.asList(staff1, staff2, staff3));
//        Product product1 = new Product();
//        product1.setName("Vios");
//        product1.setColor("Red");
//        product1.setStatus("good");
//        product1.setCode("29A 1234");
//        product1.setCustomer(customer1);
//        Product product2 = new Product();
//        product2.setName("fadil");
//        product2.setColor("blue");
//        product2.setStatus("not good");
//        product2.setCode("29A 1111");
//        product2.setCustomer(customer1);
//        Product product3 = new Product();
//        product3.setName("messcedes");
//        product3.setColor("Red");
//        product3.setStatus("good");
//        product3.setCode("29A 2222");
//        product3.setCustomer(customer2);
//        Product product4 = new Product();
//        product4.setName("audi");
//        product4.setColor("Red");
//        product4.setStatus("good");
//        product4.setCode("29A4444");
//        product4.setCustomer(customer3);
//        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));
//        Service service1 = new Service();
//        service1.setName("bao duong");
//        service1.setFee(100000);
//        Service service2 = new Service();
//        service2.setName("thay xam");
//        service2.setFee(120000);
//        Service service3 = new Service();
//        service3.setName("son lai mau xe");
//        service3.setFee(500000);
//        Service service4 = new Service();
//        service4.setName("sua dieu hoa");
//        service4.setFee(500000);
//        Service service5 = new Service();
//        service5.setName("thay lop");
//        service5.setFee(400000);
//        serviceRepository.saveAll(Arrays.asList(service1, service2, service3, service4, service5));
    }
}
