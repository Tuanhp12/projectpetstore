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



//    public OrderDetails saveOrUpdateCustomer(OrderDetails orderDetail){
//        log.debug("Request to get create OrderDetails");
//        orderDetail.setOrderDetailIdentifier(RandomIdService.returnRandomId());
//        orderDetail.setTotalPrice(0);
//        orderDetail.setStatus("Not Confirm");
//        return orderDetailRepository.save(orderDetail);
//    }
}