package com.example.picgramnew.repository;

import com.example.picgramnew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {
    User findUserById(Long userId);
}
