package com.example.Cart_and_Order.Dto;

import com.example.Cart_and_Order.entity.OrderItem;
import lombok.Data;

import java.util.List;
@Data
public class OrderDto {


    private String userId;
    private String cartId;
    private List<OrderItemDto> orderItemDtos;
}
