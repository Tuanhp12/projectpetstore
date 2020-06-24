package com.main.project.web;

import com.main.project.entity.OrderItems;
import com.main.project.service.OrderItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orderItems")
@CrossOrigin
public class OrderItemsResource {
    private final OrderItemService orderItemService;

    public OrderItemsResource(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/all")
    public Iterable<OrderItems> getAllCustomer(){
        return orderItemService.findAllCustomer();
    }
}
