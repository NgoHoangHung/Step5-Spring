package com.example.assignmentcontest;

import com.example.assignmentcontest.model.entity.*;
import com.example.assignmentcontest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentContestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentContestApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderrRepository orderrRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShiperRepository shiperRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void run(String... args) throws Exception {
//        Product product1 = new Product();
//        product1.setName("tivi");
//        product1.setWeight(5.2);
//        product1.setPrice(5000);
//        product1.setQuantity(3);
//        productRepository.save(product1);
//        Product product2 = new Product();
//        product2.setName("tu lanh");
//        product2.setWeight(20.3);
//        product2.setPrice(10000000);
//        product2.setQuantity(4);
//        productRepository.save(product2);
//        Product product3 = new Product();
//        product3.setName("noi com");
//        product3.setWeight(6);
//        product3.setPrice(1000000);
//        product3.setQuantity(3);
//        productRepository.save(product3);
//        Product product4 = new Product();
//        product4.setName("may in");
//        product4.setWeight(16);
//        product4.setPrice(20000000);
//        product4.setQuantity(3);
//        productRepository.save(product4);
//        Product product5 = new Product();
//        product5.setName("loa karaoke");
//        product5.setWeight(5);
//        product5.setPrice(2000000);
//        product5.setQuantity(2);
//        productRepository.save(product5);
//        Product product6 = new Product();
//        product6.setName("lo vi song");
//        product6.setWeight(3);
//        product6.setPrice(1000000);
//        product6.setQuantity(3);
//        productRepository.save(product6);
//        Product product7 = new Product();
//        product7.setName("noi chien khong dau");
//        product7.setWeight(3);
//        product7.setPrice(5000000);
//        product7.setQuantity(10);
//        productRepository.save(product7);
//        Product product8 = new Product();
//        product8.setName("may xay sinh to");
//        product8.setWeight(1);
//        product8.setPrice(500000);
//        product8.setQuantity(2);
//        productRepository.save(product8);
//        Product product9 = new Product();
//        product9.setName("bep tu");
//        product9.setWeight(2);
//        product9.setPrice(550000);
//        product9.setQuantity(4);
//        productRepository.save(product9);
//        Product product10 = new Product();
//        product10.setName("binh nuoc nong");
//        product10.setWeight(0.2);
//        product10.setPrice(550.5);
//        product10.setQuantity(1);
//        productRepository.save(product10);
//
//        Vote vote1 = new Vote();
//        vote1.setMessage("very bad");
//        Vote vote2 = new Vote();
//        vote2.setMessage("bad");
//        Vote vote3 = new Vote();
//        vote3.setMessage("normal");
//        Vote vote4 = new Vote();
//        vote4.setMessage("good");
//        Vote vote5 = new Vote();
//        vote5.setMessage("very good");
//
//        Wallet bank1 = new Wallet();
//        bank1.setAccount_num("000111222333aaa");
//        bank1.setBalance(5000000.0);
//        walletRepository
//                .save(bank1);
//
//        Wallet bank2 = new Wallet();
//        bank2.setAccount_num("000111222333aaa");
//        bank2.setBalance(6000000.0);
//        walletRepository
//                .save(bank2);
//
//        Wallet bank3 = new Wallet();
//        bank3.setAccount_num("000111222333bbb");
//        bank3.setBalance(7000000.0);
//        walletRepository
//                .save(bank3);
//
//        Wallet bank4 = new Wallet();
//        bank4.setAccount_num("000111222333ccc");
//        bank4.setBalance(8000000.0);
//        walletRepository
//                .save(bank4);
//
//        Wallet bank5 = new Wallet();
//        bank5.setAccount_num("000111222333ddd");
//        bank5.setBalance(9000000.0);
//        walletRepository
//                .save(bank5);
//
//        Shipper shipper1 = new Shipper();
//        shipper1.setName("ton ngo khong");
//        shipper1.setPhone("0123456789");
//        shipper1.setWallet(bank1);
//        shiperRepository
//                .save(shipper1);
//
//        Shipper shipper2 = new Shipper();
//        shipper2.setName("ton ngo khong");
//        shipper2.setPhone("0123456789");
//        shipper2.setWallet(bank2);
//        shiperRepository
//                .save(shipper2);
//
//        Shipper shipper3 = new Shipper();
//        shipper3.setName("ton ngo khong");
//        shipper3.setPhone("0123456789");
//        shipper3.setWallet(bank3);
//        shiperRepository
//                .save(shipper3);
//
//        Customer user1 = new Customer();
//        user1.setName("hungnh");
//        user1.setPhone("0111222333");
//        user1.setWallet(bank4);
//        customerRepository.
//                save(user1);
//
//        Customer user2 = new Customer();
//        user2.setName("dungnn");
//        user2.setPhone("0359222333");
//        user2.setWallet(bank5);
//        customerRepository.
//                save(user2);
    }
}
