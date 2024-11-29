package com.example.ERP.Repository;

import com.example.ERP.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
