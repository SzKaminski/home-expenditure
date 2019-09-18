package com.szkaminski.demo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expanditure")
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

    @ManyToOne
    private User user;
}
