package com.example.Cart_and_Order.Dto;



import lombok.Data;

@Data
public class CartItemDto {

    private String productId;
    private int count;
    private String merchantId;
    private String userId;
    private String emailId;

}
