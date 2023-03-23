package com.example.assignment19_jwt_bookmanager.repository;

import com.example.assignment19_jwt_bookmanager.model.entity.RefreshToken;
import com.example.assignment19_jwt_bookmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
