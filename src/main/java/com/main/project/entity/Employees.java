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
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email
    @Size(max = 100)
    private String email;

    private String Gender;

    @Column(updatable = false, unique = true)
    private String employeeIdentifier;

    @NotNull
    @Size(max = 20)
    @NotBlank(message = "Customer name is required")
    private String nameEmployee;

    @Size(max = 20)
    @NotBlank(message = "Customer phone number is required")
    private String phone;

    @Size(max = 100)
    @NotBlank(message = "Customer address is required")
    private String address;

    @Size(max = 30)
    @NotBlank(message = "Customer city is required")
    private String city;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(unique = true, updatable = false)
    private Date create_At;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_At;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    @JsonIgnore
    private Accounts account;
}

