package com.example.assignment4jpa_shopmanage;

import com.example.assignment4jpa_shopmanage.model.entity.Customer;
import com.example.assignment4jpa_shopmanage.model.entity.Product;
import com.example.assignment4jpa_shopmanage.model.entity.Shop;
import com.example.assignment4jpa_shopmanage.model.entity.Wallet;
import com.example.assignment4jpa_shopmanage.repository.CustomerRepository;
import com.example.assignment4jpa_shopmanage.repository.ProductRepository;
import com.example.assignment4jpa_shopmanage.repository.ShopRepository;
import com.example.assignment4jpa_shopmanage.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Assignment4JpaShopManageApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assignment4JpaShopManageApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public void run(String... args) throws Exception {
//        Wallet wallet1 = new Wallet("c112", 500);
//        Wallet wallet2 = new Wallet("c113", 900);
//        Wallet wallet3 = new Wallet("c114", 800);
//        Wallet wallet4 = new Wallet("c115", 1000);
//        Wallet shopwallet5 = new Wallet("s111", 1000);
//        Wallet shopwallet6 = new Wallet("s115", 1000);
//
//
//        Customer customer1 = new Customer("Hungnh", "032 1234567", "Long Bien", wallet1);
//        Customer customer2 = new Customer("ThaiPQ", "032 1111111", "To Huu", wallet2);
//        Customer customer3 = new Customer("Tiendq", "032 2222222", "Thanh Tri", wallet3);
//        Customer customer4 = new Customer("TrungNA", "032 3333333", "Hoang mai", wallet4);
////        (String nameProduct, int quantity, double price, String description)
//        Product product1 = new Product("but bi", 1000, 5000, "But bi thien long");
//        Product product2 = new Product("but chi", 2000, 5000, "But chi thien long");
//        Product product3 = new Product("giay A4", 1000, 65000, "giay in ");
//        Product product4 = new Product("tay erase", 1000, 5000, "tay thien long");
//        Product product5 = new Product("thước kẻ", 1000, 5000, "best");
//        Product product6 = new Product("bu bi red", 1000, 5000, "ben nghe");
//        Product product7 = new Product("but bi xanh", 1000, 5000, "Ben nghe");
//        Product product8 = new Product("but bi den", 1000, 5000, "But bi thien long");
//        Product product9 = new Product("but bi den", 1000, 5000, "Ben nghe");
//        Product product10 = new Product("vo o li", 1000, 5000, "vo oli ben nghe");
//        Product product11 = new Product("vo oli", 1000, 5000, "vo oli thien long");
////        Shop(String nameShop, String phone, Set<Product> products, Wallet wallet)
//        Shop shop1 = new Shop("thien long", "024 000111");
//        Shop shop2 = new Shop("ben nghe", "024 111222");
//        walletRepository.saveAll(Arrays.asList(wallet1, wallet2, wallet3, wallet4, shopwallet5, shopwallet6));
//        shop1.setWallet(shopwallet5);
//        shop2.setWallet(shopwallet6);
//        customer1.setWallet(wallet1);
//        customer2.setWallet(wallet2);
//        customer3.setWallet(wallet3);
//        customer4.setWallet(wallet4);
//        shopRepository.saveAll(Arrays.asList(shop1, shop2));
//        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3, customer4));
//        product1.setShop(shop1);
//        product2.setShop(shop1);
//        product3.setShop(shop1);
//        product4.setShop(shop1);
//        product5.setShop(shop1);
//        product8.setShop(shop2);
//        product11.setShop(shop2);
//        product6.setShop(shop2);
//        product7.setShop(shop2);
//        product9.setShop(shop2);
//        product10.setShop(shop2);
//        product10.setShop(shop2);
//        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10, product11));
    }
}
