package com.main.project.web;

import com.main.project.entity.OrderDetails;
import com.main.project.entity.OrderItems;
import com.main.project.service.MapValidationErrorService;
import com.main.project.service.OrderDetailService;
import com.main.project.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/orderDetails")
@CrossOrigin
public class OrderDetailResource {
    private final Logger log = LoggerFactory.getLogger(OrderDetailResource.class);

    private final OrderDetailService orderDetailService;

    public OrderDetailResource(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/{id}")
    public OrderDetails updateOrderDetail(@PathVariable String id ,@RequestBody OrderDetails orderDetails){
        return orderDetailService.updateOrderDetail(id, orderDetails);
    }

    @GetMapping("/{customer_id}")
    public OrderDetails getByCustomerIdentifier(@PathVariable(value = "customer_id") String id){
        return orderDetailService.getOrderDetailByCustomerIdentifier(id);
    }

}




//@GetMapping("/maxDate")
//    public OrderDetails getByMostRecentDate(){
//        return orderDetailService.getMaxDateTime();
//    }