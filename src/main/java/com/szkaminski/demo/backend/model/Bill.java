package com.szkaminski.demo.backend.model;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

public class Bill {

    private List<User> owners;
    private BigDecimal sum;

    private Year yearOfCreation;
    private Year yearOfDeleted;
}
