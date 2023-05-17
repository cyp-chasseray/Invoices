package com.example.billeditor.repository;

import com.example.billeditor.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAllByUserId(long id);
}
