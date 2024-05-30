package com.example.gtics_lab7_20203521.repository;

import com.example.gtics_lab7_20203521.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query(value = "select * from players where region like %?1% order by mmr desc" , nativeQuery = true)
    List<Product> buscarPorRegion(String nombreRegion);
}

