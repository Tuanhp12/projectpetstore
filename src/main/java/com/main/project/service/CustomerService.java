package com.main.project.service;

import com.main.project.entity.Customers;
import com.main.project.entity.OrderDetails;
import com.main.project.exception.CustomerIdException;
import com.main.project.exception.ResourceNotFoundException;
import com.main.project.repository.CustomerRepository;
import com.main.project.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderDetailRepository orderDetailRepository;

    public CustomerService(CustomerRepository customerRepository, OrderDetailRepository orderDetailRepository) {
        this.customerRepository = customerRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Customers saveOrUpdateCustomer(Customers customer){

//        customer.setCustomerIdentifier(RandomIdService.returnRandomId(customer.getNameCustomer()));

        //only one to one can do this
        if(customer.getId() == null){
            OrderDetails orderDetail = new OrderDetails();
            customer.setOrderDetail(orderDetail);
            orderDetail.setCustomer(customer);
            orderDetail.setCustomerIdentifier(customer.getCustomerIdentifier());
            orderDetail.setStatus("Not Confirm");
            orderDetail.setTotalPrice(0);
            orderDetail.setOrderDetailIdentifier(RandomIdService.returnRandomId());
            orderDetail.setAccount(null);
        }

        if(customer.getId() != null){
            customer.setOrderDetail(orderDetailRepository.findByCustomerIdentifier(customer.getCustomerIdentifier()));
        }

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

    public void deleteProjectByIdentifier(String customerId){
        Customers customer = findCustomerByIdentifier(customerId);
        if(customer == null){
            throw new CustomerIdException("Customer ID '"+customerId+"' does not exist");
        }
        customerRepository.delete(customer);
    }
}
