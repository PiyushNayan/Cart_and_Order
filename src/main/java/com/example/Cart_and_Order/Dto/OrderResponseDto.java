package com.example.Cart_and_Order.Dto;

import lombok.Data;

import java.util.List;
@Data
public class OrderResponseDto {

    private String orderId;
    private String userId;
    private String cartId;
    private List<OrderItemResponseDto> orderItemResponseDtos;
}
