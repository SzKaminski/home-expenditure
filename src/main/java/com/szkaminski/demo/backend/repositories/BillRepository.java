package com.szkaminski.demo.backend.repositories;

import com.szkaminski.demo.backend.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("from Bill where name like %:name%")
    Bill findByName(@Param("name")String name);
}
