package com.szkaminski.demo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> owners;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "yearOfCreation")
    private Year yearOfCreation;

    @Column(name = "yearOfDeleted")
    private Year yearOfDeleted;
}
