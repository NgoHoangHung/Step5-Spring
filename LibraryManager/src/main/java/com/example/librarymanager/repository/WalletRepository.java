package com.example.librarymanager.repository;

import com.example.librarymanager.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    boolean existsByAccountNum(String account);

    Wallet findByAccountNum(String account);

    @Query("SELECT w FROM Wallet w JOIN Borrower b WHERE b.phone = :phone")
    Wallet findByBorrowerPhone(String phone);

    boolean existsByBorrower_Phone(String phone);
}
