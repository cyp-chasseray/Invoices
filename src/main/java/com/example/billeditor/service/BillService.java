package com.example.billeditor.service;

import com.example.billeditor.entity.Bill;
import com.example.billeditor.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> fetchAllBills() {
        return billRepository.findAll();
    }

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }
}
