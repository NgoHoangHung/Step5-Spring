package com.example.assignment19_jwt_bookmanager.repository;

import com.example.assignment19_jwt_bookmanager.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
     List<Authority> findAll();
}
