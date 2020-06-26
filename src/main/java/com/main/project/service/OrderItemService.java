package com.main.project.service;

import com.main.project.entity.OrderDetails;
import com.main.project.entity.OrderItems;
import com.main.project.entity.Products;
import com.main.project.exception.ResourceNotFoundException;
import com.main.project.repository.OrderDetailRepository;
import com.main.project.repository.OrderItemRepository;
import com.main.project.repository.ProductRepository;
import com.main.project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderDetailRepository orderDetailRepository;

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;

    public OrderItemService(OrderDetailRepository orderDetailRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    public OrderItems addOrderItem(OrderItems orderItems){
        try{
            if(orderDetailRepository.findByOrderDetailIdentifier(orderItems.getOrderDetailIdentifier()) == null){
                throw new ResourceNotFoundException("Cant not find OrderDetail with :" + orderItems.getOrderDetailIdentifier());
            }
            if(productRepository.findByProductIdentifier(orderItems.getProductIdentifier()) == null){
                throw new ResourceNotFoundException("Cant not find Product with :" + orderItems.getProductIdentifier());
            }
            return orderItemRepository.save(orderItems);
        }catch (Exception e){
            throw new ResourceNotFoundException("Can't find Order Item");
        }
    }

    public List<OrderItems> findAllOrderItems(){
        return orderItemRepository.findAll();
    }
}
