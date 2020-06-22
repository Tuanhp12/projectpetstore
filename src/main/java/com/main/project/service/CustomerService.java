package com.main.project.service;

import com.main.project.entity.Customers;
import com.main.project.exception.CustomerIdException;
import com.main.project.exception.ResourceNotFoundException;
import com.main.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ProductService productService;

    public CustomerService(CustomerRepository customerRepository, ProductService productService) {
        this.customerRepository = customerRepository;
        this.productService = productService;
    }

    public Customers saveOrUpdateCustomer(Customers customer){

        customer.setCustomerIdentifier(RandomIdService.returnRandomId(customer.getNameCustomer()));
        return customerRepository.save(customer);
    }

    public Customers findCustomerByIdentifier(String customerId){
        Customers customer = customerRepository.findByCustomerIdentifier(customerId.toUpperCase());

        if(customer == null){
            throw new CustomerIdException("Customer ID '"+customerId+"' does not exist");
        }
        return customer;
    }

    public Iterable<Customers> findAllCustomer(){
        return customerRepository.findAll();
    }

}
