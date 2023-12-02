package com.example.Cart_and_Order.repositories;

import com.example.Cart_and_Order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findByCartId(String cartId);

}
