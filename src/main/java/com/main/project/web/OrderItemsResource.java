package com.main.project.web;

import com.main.project.entity.OrderDetails;
import com.main.project.entity.OrderItems;
import com.main.project.service.MapValidationErrorService;
import com.main.project.service.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderItems")
@CrossOrigin
public class OrderItemsResource {
    private final OrderItemService orderItemService;
    private final MapValidationErrorService mapValidationErrorService;

    public OrderItemsResource(OrderItemService orderItemService, MapValidationErrorService mapValidationErrorService) {
        this.orderItemService = orderItemService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @GetMapping("/all")
    public List<OrderItems> getAllCustomer(){
        return orderItemService.findAllOrderItems();
    }

    @PostMapping("")
    public ResponseEntity<?> createOrderItems(@RequestBody OrderItems orderItems){
        orderItemService.addOrderItem(orderItems);
        return new ResponseEntity<OrderItems>(orderItems, HttpStatus.CREATED);
    }
}
