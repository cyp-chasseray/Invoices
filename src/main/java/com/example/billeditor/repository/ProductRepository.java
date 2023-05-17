package com.example.billeditor.repository;

import com.example.billeditor.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIdIn(List<Long> ids);

    List<Product> findAllByUserId(long id);
}

