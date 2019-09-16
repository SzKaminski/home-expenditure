package com.szkaminski.demo.backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<User> owners;
    private BigDecimal sum;

    private Year yearOfCreation;
    private Year yearOfDeleted;
}
