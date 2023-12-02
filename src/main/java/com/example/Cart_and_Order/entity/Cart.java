package com.example.Cart_and_Order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "Cart")
@Data
public class Cart {

    @Id
    private String cartId;
    private List<String> cardItemIds;
    private String userId;

}