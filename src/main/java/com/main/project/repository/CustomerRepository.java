package com.main.project.repository;

import com.main.project.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    Customers findByCustomerIdentifier(String customerId);
}
