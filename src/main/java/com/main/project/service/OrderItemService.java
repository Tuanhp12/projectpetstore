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

    public OrderItems addOrderItem(String orderDetailIdentifier, String productIdentifier, OrderItems orderItems){
        try{
            if(orderDetailRepository.findByOrderDetailIdentifier(orderDetailIdentifier) == null){
                throw new ResourceNotFoundException("Cant not find OrderDetail with :" + orderDetailIdentifier);
            }
            OrderDetails orderDetail = orderDetailRepository.findByOrderDetailIdentifier(orderDetailIdentifier);
            orderItems.setOrderDetailIdentifier(orderDetail.getOrderDetailIdentifier());
            orderItems.setOrderDetail(orderDetail);
            if(productRepository.findByProductIdentifier(productIdentifier) == null){
                throw new ResourceNotFoundException("Cant not find Product with :" + orderDetailIdentifier);
            }
            Products product = productRepository.findByProductIdentifier(productIdentifier);
            orderItems.setProductIdentifier(product.getProductIdentifier());
            orderItems.setProduct(product);
            return orderItemRepository.save(orderItems);
        }catch (Exception e){
            throw new ResourceNotFoundException("Can't find Order Item");
        }
    }

    public Iterable<OrderItems> findAllCustomer(){
        return orderItemRepository.findAll();
    }
}
