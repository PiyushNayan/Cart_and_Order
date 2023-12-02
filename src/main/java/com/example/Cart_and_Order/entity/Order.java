package com.example.Cart_and_Order.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Order")
@Data
public class Order {

    @Id
    private String orderId;
    private String userId;
    private String cartId;
    private List<String> orderItemIds;


}

