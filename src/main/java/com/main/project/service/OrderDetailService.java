package com.main.project.service;

import com.main.project.entity.OrderDetails;
import com.main.project.entity.OrderItems;
import com.main.project.exception.ResourceNotFoundException;
import com.main.project.repository.OrderDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class OrderDetailService {
    private final Logger log = LoggerFactory.getLogger(OrderDetailService.class);

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetails getOrderDetailByCustomerIdentifier(String id){
        return orderDetailRepository.findByCustomerIdentifier(id);
    }

    public OrderDetails getMaxDateTime(){
        List<OrderDetails> orderDetailsList = orderDetailRepository.findAll();
        OrderDetails orderDetails = orderDetailsList.get(0);
        for(int i = 1; i < orderDetailsList.size(); i++) {
            if(orderDetailsList.get(i).getCreated_At().getTime() > orderDetails.getCreated_At().getTime()) {
                orderDetails = orderDetailsList.get(i);
            }
        }
        return orderDetails;
    }

    public OrderDetails getOrderDetailByIdentifier(String id){
        return orderDetailRepository.findByOrderDetailIdentifier(id);
    }

//    public OrderDetails saveOrUpdateCustomer(OrderDetails orderDetail){
//        log.debug("Request to get create OrderDetails");
//        orderDetail.setOrderDetailIdentifier(RandomIdService.returnRandomId());
//        orderDetail.setTotalPrice(0);
//        orderDetail.setStatus("Not Confirm");
//        return orderDetailRepository.save(orderDetail);
//    }
    public OrderDetails updateOrderItemsInOrderDetail(String orderDetailsIdentifier, List<OrderItems> orderItems){
        if(orderDetailRepository.findByOrderDetailIdentifier(orderDetailsIdentifier) == null){
            throw new ResourceNotFoundException("Can't find Order Detail");
        }
        OrderDetails orderDetails = orderDetailRepository.findByOrderDetailIdentifier(orderDetailsIdentifier);
        orderDetails.setOrderItems(orderItems);
        return orderDetailRepository.save(orderDetails);
    }

    public OrderDetails updateStatusOrderDetail(){
        return null;
    }
}