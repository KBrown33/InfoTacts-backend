package com.example.picgramnew.repository;

import com.example.picgramnew.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository {
    Message findMessageById(Long Id);
}
