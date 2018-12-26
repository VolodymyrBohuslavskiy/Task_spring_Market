package com.example.demo2.dao;

import com.example.demo2.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailDAO extends JpaRepository<Email, Integer> {

    List<Email> findAllByAdres(String adress);
}
