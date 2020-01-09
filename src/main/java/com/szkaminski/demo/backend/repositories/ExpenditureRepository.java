package com.szkaminski.demo.backend.repositories;

import com.szkaminski.demo.backend.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    Expenditure getExpenditureById(Long id);
}
