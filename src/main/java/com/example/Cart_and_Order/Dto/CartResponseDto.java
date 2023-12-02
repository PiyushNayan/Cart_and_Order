package com.example.Cart_and_Order.Dto;

import com.example.Cart_and_Order.entity.CartItem;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
public class CartResponseDto {


    private String cartId;
    private List<CartItemDto> cartItemDtos;
    private String userId;
}
