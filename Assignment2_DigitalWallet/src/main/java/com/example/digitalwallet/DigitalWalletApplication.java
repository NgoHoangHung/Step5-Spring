package com.example.digitalwallet;

import com.example.digitalwallet.model.entity.Account;
import com.example.digitalwallet.model.entity.Wallet;
import com.example.digitalwallet.repository.AccountRepository;
import com.example.digitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DigitalWalletApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DigitalWalletApplication.class, args);
    }

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void run(String... args) throws Exception {
//        Wallet bank1 = new Wallet();
//        bank1.setBank("viettinbank");
//        Wallet bank2 = new Wallet();
//        bank2.setBank("techcombank");
//        Wallet bank3 = new Wallet();
//        bank3.setBank("agribank");
//        walletRepository.saveAll(Arrays.asList(bank1, bank2, bank3));
//
//        Account account1 = new Account();
//        account1.setName("hungnh");
//        account1.setPassword("123");
//        account1.setWallet(bank1);
//
//        Account account2 = new Account();
//        account2.setName("nambh");
//        account2.setPassword("122");
//        account2.setWallet(bank1);
//
//        Account account3 = new Account();
//        account3.setName("trungap");
//        account3.setPassword("111");
//        account3.setWallet(bank2);
//
//       Account account4 = new Account();
//        account4.setName("tiendq");
//        account4.setPassword("222");
//        account4.setWallet(bank3);
//        accountRepository.saveAll(Arrays.asList(account1, account2, account3, account4));
    }
}
