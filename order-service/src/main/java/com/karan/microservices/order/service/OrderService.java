package com.karan.microservices.order.service;

import com.karan.microservices.order.client.InventoryClient;
import com.karan.microservices.order.dto.OrderRequest;
import com.karan.microservices.order.model.Order;
import com.karan.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InventoryClient inventoryClient;

    public  void  placeOrder(OrderRequest orderRequest){

        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if(inStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            orderRepository.save(order);
        }
        throw new RuntimeException("Product with skuCode "+ orderRequest.skuCode() + "is not in stock");


    }
}
