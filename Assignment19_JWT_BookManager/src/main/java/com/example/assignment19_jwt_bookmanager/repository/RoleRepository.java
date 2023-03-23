package com.example.assignment19_jwt_bookmanager.repository;

import com.example.assignment19_jwt_bookmanager.model.entity.ERole;
import com.example.assignment19_jwt_bookmanager.model.entity.RefreshToken;
import com.example.assignment19_jwt_bookmanager.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
     Optional<Role> findByName(ERole name);
}
