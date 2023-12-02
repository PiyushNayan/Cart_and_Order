package com.example.Cart_and_Order.controller;


import com.example.Cart_and_Order.Dto.CartItemDto;
import com.example.Cart_and_Order.Dto.CartResponseDto;
import com.example.Cart_and_Order.Dto.OrderItemResponseDto;
import com.example.Cart_and_Order.Dto.OrderResponseDto;
import com.example.Cart_and_Order.entity.Cart;
import com.example.Cart_and_Order.entity.CartItem;
import com.example.Cart_and_Order.entity.Order;
import com.example.Cart_and_Order.entity.OrderItem;
import com.example.Cart_and_Order.repositories.CartItemRepository;
import com.example.Cart_and_Order.repositories.CartRepository;
import com.example.Cart_and_Order.service.CartItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @PostMapping("/addToCart")
    public ResponseEntity<Boolean> addToCart(@RequestBody CartItemDto cartItemDto ) {
        Boolean inserted = cartItemService.addItemToCart(cartItemDto);

        if (inserted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getCartById/{cartId}")
    public CartResponseDto getAllOrdersByCartId(@PathVariable("cartId")  String cartId) {

        Optional<Cart> cart = cartRepository.findById(cartId);
        CartResponseDto cartResponseDto = new CartResponseDto();
        if (cart.isPresent()) {
            Cart cart1 = cart.get();
            List<CartItemDto> cartItemDtos = new ArrayList<>();
            for (String cartItemId : cart1.getCardItemIds()) {
                CartItem cartItem = cartItemRepository.findById(cartItemId).get();
                CartItemDto cartItemDto = new CartItemDto();
                BeanUtils.copyProperties(cartItem, cartItemDto);
                cartItemDtos.add(cartItemDto);
            }

            cartResponseDto.setCartItemDtos(cartItemDtos);
            cartResponseDto.setCartId(cartId);
            cartResponseDto.setUserId(cart1.getUserId());
            return cartResponseDto;
        } else {
            return null;
        }

    }
}