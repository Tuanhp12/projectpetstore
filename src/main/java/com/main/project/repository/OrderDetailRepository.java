package com.main.project.repository;

import com.main.project.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {
    OrderDetails findByCustomerIdentifier(String identifier);

    @Query("select o from OrderDetails o where o.orderDetailIdentifier = :id")
    OrderDetails findByOrderDetailIdentifier(String id);
}

