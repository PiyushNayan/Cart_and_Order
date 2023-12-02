package com.example.Cart_and_Order.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CartItem")
@Data
public class CartItem {

    @Id
    private String cartItemId;
    private String productId;
    private String merchantId;
    private int count;


}

