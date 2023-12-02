package com.example.Cart_and_Order.service.impl;

import com.example.Cart_and_Order.Dto.OrderDto;
import com.example.Cart_and_Order.Dto.OrderItemDto;
import com.example.Cart_and_Order.entity.Order;
import com.example.Cart_and_Order.entity.OrderItem;
import com.example.Cart_and_Order.repositories.OrderItemRepository;
import com.example.Cart_and_Order.repositories.OrderRepository;
import com.example.Cart_and_Order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Boolean placeOrder(OrderDto orderDto) {

        List<String> orderItemIds = new ArrayList<>();

        for (OrderItemDto orderItemDto: orderDto.getOrderItemDtos()) {
          OrderItem orderItem = new OrderItem();
          BeanUtils.copyProperties(orderItemDto,orderItem);
          String orderItemId = UUID.randomUUID().toString();
          orderItem.setOrderItemId(orderItemId);
          orderItemRepository.save(orderItem);
          orderItemIds.add(orderItemId);

        }

        Order order = new Order();
        order.setCartId(orderDto.getCartId());
        order.setOrderId(UUID.randomUUID().toString());
        order.setUserId(orderDto.getUserId());
        order.setOrderItemIds(orderItemIds);
        Order order1 = orderRepository.save(order);


        return Objects.nonNull(order1);
    }
}
