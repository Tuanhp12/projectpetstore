package com.main.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(updatable = false)
//    private String productSequence;

//    private Integer priority;

    @NotNull
    @Column(unique = true, updatable = false)
    private String productIdentifier;

    @NotNull
    @Column(updatable = false)
    private String categoryIdentifier;

    @NotBlank
    @Size(max = 100)
    private String name;

    private String image;

    @NotBlank(message = "Project description is required")
    @Size(max=10000)
    private String description;

    @NotNull
    private int currentQuantity;

    @NotNull
    private double price;

    private String status;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(unique = true, updatable = false)
    private Date create_At;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_At;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", updatable = false,nullable = false)
    @JsonIgnore
    private Categories category;

//    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "product", orphanRemoval = true)
//    private List<Sales> sales = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "product", orphanRemoval = true)
//    private List<OrderItems> orderItems = new ArrayList<>();

    public Products() {
    }

    @PrePersist
    protected void onCreate(){
        this.create_At = new Date();
    }

    @PreUpdate
    protected void opUpdate(){
        this.update_At = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getCategoryIdentifier() {
        return categoryIdentifier;
    }

    public void setCategoryIdentifier(String categoryIdentifier) {
        this.categoryIdentifier = categoryIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_At() {
        return create_At;
    }

    public void setCreate_At(Date create_At) {
        this.create_At = create_At;
    }

    public Date getUpdate_At() {
        return update_At;
    }

    public void setUpdate_At(Date update_At) {
        this.update_At = update_At;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

//    public List<Sales> getSales() {
//        return sales;
//    }
//
//    public void setSales(List<Sales> sales) {
//        this.sales = sales;
//    }
//
//    public List<OrderItems> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItems> orderItems) {
//        this.orderItems = orderItems;
//    }
}

