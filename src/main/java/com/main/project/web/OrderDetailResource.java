package com.main.project.web;

import com.main.project.entity.OrderDetails;
import com.main.project.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orderDetails")
@CrossOrigin
public class OrderDetailResource {
    private final Logger log = LoggerFactory.getLogger(OrderDetailResource.class);

    private final OrderDetailService orderDetailService;

    public OrderDetailResource(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

//    @PostMapping("")
//    public ResponseEntity<?> createNewCustomer(@RequestBody OrderDetails orderDetails){
//
//        OrderDetails orderDetails1 = orderDetailService.saveOrUpdateCustomer(orderDetails);
//        return new ResponseEntity<OrderDetails>(orderDetails1, HttpStatus.CREATED);
//    }
}
