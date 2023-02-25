package com.example.librarymanager.repository;

import com.example.librarymanager.model.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
    boolean existsByPhone(String phone);

    Borrower findByPhone(String phone);
}
