package com.example.librarymanager;

import com.example.librarymanager.model.entity.*;
import com.example.librarymanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LibraryManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagerApplication.class, args);
    }


    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public void run(String... args) throws Exception {
//        Type type1 = new Type();
//        type1.setName("trinh thám");
//        Type type2 = new Type();
//        type2.setName("tiểu thuyết");
//        Type type3 = new Type();
//        type3.setName("truyện tiếu lâm");
//        Type type4 = new Type();
//        type4.setName("truyện thiếu nhi");
//        Type type5 = new Type();
//        type5.setName("truyện văn học");
//        Type type6 = new Type();
//        type6.setName("truyện ma");
//
//
//        typeRepository.saveAll(Arrays.asList(type1, type2, type3, type4,type5,type6));
//        final Wallet libaryCenter = new Wallet();
//        libaryCenter.setAccountNum("123123");
//        libaryCenter.setBalance(100000);
//
//        Wallet bWallet1 = new Wallet();
//        bWallet1.setAccountNum("A123456");
//        bWallet1.setBalance(500000);
//
//        Wallet bWallet2 = new Wallet();
//        bWallet2.setAccountNum("B123456");
//        bWallet2.setBalance(600000);
//
//        Wallet bWallet3 = new Wallet();
//        bWallet3.setAccountNum("C123456");
//        bWallet3.setBalance(700000);
//
//        Wallet bWallet4 = new Wallet();
//        bWallet4.setAccountNum("D123456");
//        bWallet4.setBalance(800000);
//        walletRepository.saveAll(Arrays.asList(libaryCenter, bWallet1, bWallet2, bWallet3, bWallet4));
//
//        Borrower borrower1 = new Borrower();
//        borrower1.setName("hungnh");
//        borrower1.setPhone("0366333222");
//        borrower1.setCccd("031091220111");
//        borrower1.setWallet(bWallet1);
//        borrowerRepository.save(borrower1);
//        Borrower borrower2 = new Borrower();
//        borrower2.setName("tiendq");
//        borrower2.setPhone("0366333222");
//        borrower2.setCccd("031091220123");
//        borrower2.setWallet(bWallet2);
//        borrowerRepository.save(borrower2);
//        Borrower borrower3 = new Borrower();
//        borrower3.setName("thaipq");
//        borrower3.setPhone("0366123422");
//        borrower3.setCccd("031091220222");
//        borrower3.setWallet(bWallet3);
//        borrowerRepository.save(borrower3);
//        Borrower borrower4 = new Borrower();
//        borrower4.setName("trungna");
//        borrower4.setPhone("0366432122");
//        borrower4.setCccd("031091220333");
//        borrower4.setWallet(bWallet4);
//        borrowerRepository.save(borrower4);
    }

}

//        Book book1 = new Book();
//        book1.setName("Lão hạc");
//        book1.setAuthor("abc");
//        book1.setPrice(50000);
//        book1.setType(type1);
//        Book book2 = new Book();
//        book2.setName("Rế mèn phiêu lưu kí");
//        book2.setAuthor("Tô Hoài ");
//        book2.setPrice(30000);
//        book2.setType(type1);
//        Book book3 = new Book();
//        book3.setName("cô nan");
//        book3.setAuthor("i kự i kự");
//        book3.setPrice(60000);
//        book3.setType(type3);
//        bookRepository.saveAll(Arrays.asList(book1, book2, book3));












