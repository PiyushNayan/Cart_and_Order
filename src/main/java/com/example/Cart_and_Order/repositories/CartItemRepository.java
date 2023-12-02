package com.example.Cart_and_Order.repositories;


import com.example.Cart_and_Order.entity.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem,String> {

}

