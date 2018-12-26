package com.example.demo2.dao;

import com.example.demo2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
//    CRUD-операции CRUD — (create read update delete — «Создание чтение обновление удаление»)
}
