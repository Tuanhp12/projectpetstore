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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }
}