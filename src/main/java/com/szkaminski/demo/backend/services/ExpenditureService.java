package com.szkaminski.demo.backend.services;

import com.szkaminski.demo.backend.model.Expenditure;
import com.szkaminski.demo.backend.repositories.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenditureService {

    @Autowired
    ExpenditureRepository expenditureRepository;

    public Expenditure getById(Long id) {
        return expenditureRepository.getExpenditureById(id);
    }

    public void addExpend(Expenditure exp) {

        expenditureRepository.save(exp);
    }
}
