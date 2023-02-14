package com.example.assignmentcontest.repository;

import com.example.assignmentcontest.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,String> {
}
