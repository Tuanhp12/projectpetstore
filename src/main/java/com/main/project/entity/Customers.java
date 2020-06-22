package com.main.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email
    @Size(max = 100)
    private String email;

    @Column(updatable = false, unique = true)
    private String customerIdentifier;

    @NotNull
    @Size(max = 20)
    @NotBlank(message = "Customers name is required")
    private String nameCustomer;

    @Size(max = 20)
    @NotBlank(message = "Customers phone number is required")
    private String phone;

    @Size(max = 100)
    @NotBlank(message = "Customers address is required")
    private String address;

    private String Gender;

    @Size(max = 30)
    @NotBlank(message = "Customers city is required")
    private String city;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(unique = true, updatable = false)
    private Date create_At;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_At;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="orderdetail_id")
    @JsonIgnore
    private Customers customer;

    public Customers() {
    }

    @PrePersist
    protected void onCreate(){
        this.create_At = new Date();
    }

    @PreUpdate
    protected void opUpdate(){
        this.update_At = new Date();
    }
}