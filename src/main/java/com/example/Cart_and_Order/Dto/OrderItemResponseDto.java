package com.example.Cart_and_Order.Dto;

import lombok.Data;

@Data
public class OrderItemResponseDto {

    private  String orderItemId;
    private  String productId;
    private  String merchantId;
}
