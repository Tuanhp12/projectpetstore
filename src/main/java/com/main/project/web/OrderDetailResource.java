package com.main.project.web;

import com.main.project.entity.OrderDetails;
import com.main.project.entity.OrderItems;
import com.main.project.service.MapValidationErrorService;
import com.main.project.service.OrderDetailService;
import com.main.project.service.OrderItemService;
import com.main.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orderDetails")
@CrossOrigin
public class OrderDetailResource {
    private final Logger log = LoggerFactory.getLogger(OrderDetailResource.class);

    private final OrderDetailService orderDetailService;
    private final MapValidationErrorService mapValidationErrorService;
    private final OrderItemService orderItemService;

    public OrderDetailResource(OrderDetailService orderDetailService, MapValidationErrorService mapValidationErrorService, OrderItemService orderItemService) {
        this.orderDetailService = orderDetailService;
        this.mapValidationErrorService = mapValidationErrorService;
        this.orderItemService = orderItemService;
    }

    @PostMapping("/orderItems/{orderDetail_id}/{product_id}")
    public ResponseEntity<?> addPTtoBacklog(@RequestBody OrderItems orderItems,
                                            BindingResult result, @PathVariable String orderDetail_id,
                                            @PathVariable String product_id){
        //show delete
        //custom exception

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        OrderItems orderItems1 = orderItemService.addOrderItem(orderDetail_id, product_id ,orderItems);

        return new ResponseEntity<OrderItems>(orderItems1, HttpStatus.CREATED);

    }
}
