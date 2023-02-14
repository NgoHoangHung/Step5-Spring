package com.example.assignment4jpa_shopmanage;

import com.example.assignment4jpa_shopmanage.model.entity.Customer;
import com.example.assignment4jpa_shopmanage.model.entity.Wallet;
import com.example.assignment4jpa_shopmanage.repository.CustomerRepository;
import com.example.assignment4jpa_shopmanage.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class Assignment4JpaShopManageApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assignment4JpaShopManageApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void run(String... args) throws Exception {
//        Wallet wallet1 = new Wallet("a112", "Viettinbank", 500);
//        Wallet wallet2 = new Wallet("a113", "techcombak", 900);
//        Wallet wallet3 = new Wallet("a114", "agribank", 800);
//        Wallet wallet4 = new Wallet("a115", "BIDV", 1000);
//        walletRepository.saveAll(Arrays.asList(wallet1, wallet2, wallet3, wallet4));
//
//        Customer customer1 = new Customer("Hungnh", "032 1234567", "Long Bien", wallet1);
//        Customer customer2 = new Customer("ThaiPQ", "032 1234567", "Long Bien", wallet3);
//        Customer customer3 = new Customer("Tiendq", "032 1234567", "Long Bien", wallet4);
//        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

    }
}
