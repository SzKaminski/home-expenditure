package com.szkaminski.demo.backend.services;

import com.szkaminski.demo.backend.model.Bill;
import com.szkaminski.demo.backend.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill addNewBill(Bill bill){
        return billRepository.save(bill);
    }
}
