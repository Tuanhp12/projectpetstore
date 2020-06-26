package com.main.project.service;

import com.main.project.entity.OrderDetails;
import com.main.project.repository.OrderDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


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

    public OrderDetails getOrderDetailByIdentifier(String id){
        return orderDetailRepository.findByOrderDetailIdentifier(id);
    }

    public OrderDetails updateOrderDetail(String id,OrderDetails orderDetails){
        OrderDetails orderDetails1 = getOrderDetailByCustomerIdentifier(id);
        orderDetails1.setTotalPrice(orderDetails.getTotalPrice());
        orderDetails1.setStatus(orderDetails.getStatus());
        return orderDetailRepository.save(orderDetails1);
    }

}


//    public OrderDetails getMaxDateTime(){
//        List<OrderDetails> orderDetailsList = orderDetailRepository.findAll();
//
//        if(orderDetailsList == null){
//            throw new ResourceNotFoundException("Dont have any Order Details");
//        }
//        OrderDetails orderDetails = orderDetailsList.get(0);
//        for(int i = 1; i < orderDetailsList.size(); i++) {
//            if(orderDetailsList.get(i).getCreated_At().getTime() > orderDetails.getCreated_At().getTime()) {
//                orderDetails = orderDetailsList.get(i);
//            }
//        }
//        return orderDetails;
//    }

//    public OrderDetails saveOrUpdateCustomer(OrderDetails orderDetail){
//        log.debug("Request to get create OrderDetails");
//        orderDetail.setOrderDetailIdentifier(RandomIdService.returnRandomId());
//        orderDetail.setTotalPrice(0);
//        orderDetail.setStatus("Not Confirm");
//        return orderDetailRepository.save(orderDetail);
//    }