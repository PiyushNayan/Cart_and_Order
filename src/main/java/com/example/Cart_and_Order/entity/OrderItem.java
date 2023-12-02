package com.example.Cart_and_Order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OrderItem")
@Data

public class OrderItem {

    @Id
    private  String orderItemId;
    private  int productId;
    private  int merchantId;

}
