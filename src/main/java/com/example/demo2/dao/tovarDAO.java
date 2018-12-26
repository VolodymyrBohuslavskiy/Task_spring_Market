package com.example.demo2.dao;

import com.example.demo2.models.tovar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface tovarDAO extends JpaRepository<tovar, Integer> {

    @Query("select t from tovar t where t.prise>:p")
    List<tovar> byPrice(@Param("p") int p);

}
