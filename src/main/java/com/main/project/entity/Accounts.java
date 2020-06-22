package com.main.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, updatable = false)
    private String username;

    @NotNull
    @Column(unique = true, updatable = false)
    private String password;

    @NotNull
    @Column(unique = true, updatable = false)
    private String accountIdentifier;

//    @OneToMany(cascade = CascadeType.REFRESH,
//            fetch = FetchType.EAGER,
//            mappedBy = "account",
//            orphanRemoval = true)
//    private List<OrderDetails> orders = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id",nullable = false)
    @JsonIgnore
    private Employees employee;
}