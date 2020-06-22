package com.main.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orderItem")
public class OrderItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_item_id", updatable = false,nullable = false)
    @JsonIgnore
    private OrderDetails orderDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", updatable = false,nullable = false)
    @JsonIgnore
    private Products product;

    @NotNull
    private Integer amount;

    @NotNull
    private double priceEach;

}