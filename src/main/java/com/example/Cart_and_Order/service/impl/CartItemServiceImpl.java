package com.example.Cart_and_Order.service.impl;

import com.example.Cart_and_Order.Dto.CartItemDto;
import com.example.Cart_and_Order.entity.Cart;
import com.example.Cart_and_Order.entity.CartItem;
import com.example.Cart_and_Order.repositories.CartItemRepository;
import com.example.Cart_and_Order.repositories.CartRepository;
import com.example.Cart_and_Order.service.CartItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public boolean addItemToCart(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(cartItemDto, cartItem);
        cartItem.setCartItemId(UUID.randomUUID().toString());
        CartItem cartItem1 = cartItemRepository.save(cartItem);

        List<String> cardItemIds = new ArrayList<>();


        Optional<Cart> cart = cartRepository.findById(cartItemDto.getEmailId());
        if (cart.isPresent()) {
            cardItemIds = cart.get().getCardItemIds();
        }
        Cart cart1 = new Cart();
        cardItemIds.add(cartItem1.getCartItemId());
        cart1.setCardItemIds(cardItemIds);
        cart1.setCartId(cartItemDto.getEmailId());
        cart1.setUserId(cartItemDto.getUserId());

        cartRepository.save(cart1);


        return Objects.nonNull(cartItem1);
    }
}
