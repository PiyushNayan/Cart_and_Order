package com.example.Cart_and_Order.service;

import com.example.Cart_and_Order.Dto.OrderDto;
import com.example.Cart_and_Order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderService {
    Boolean placeOrder(OrderDto orderDto);
}
