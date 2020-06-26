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

    @NotNull
    private String productIdentifier;//1,2

    @NotNull String orderDetailIdentifier;//1,1

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "order_item_id", nullable = false)
//    @JsonIgnore
//    private OrderDetails orderDetail;//1,1
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "product_id", nullable = false)
//    @JsonIgnore
//    private Products product;//1,2

    private Integer amount; // orderItem
    private double priceEach;// orderItem

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getOrderDetailIdentifier() {
        return orderDetailIdentifier;
    }

    public void setOrderDetailIdentifier(String orderDetailIdentifier) {
        this.orderDetailIdentifier = orderDetailIdentifier;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }
}