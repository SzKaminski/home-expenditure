package com.szkaminski.demo.backend.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expenditure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "type")
    @Enumerated
    private Type type;

    @Column(name = "user")
    private User user;
}
