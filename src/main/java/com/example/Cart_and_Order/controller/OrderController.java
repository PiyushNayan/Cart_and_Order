package com.example.Cart_and_Order.controller;
import com.example.Cart_and_Order.Dto.OrderDto;

import com.example.Cart_and_Order.Dto.OrderItemResponseDto;
import com.example.Cart_and_Order.Dto.OrderResponseDto;
import com.example.Cart_and_Order.entity.Order;
import com.example.Cart_and_Order.entity.OrderItem;
import com.example.Cart_and_Order.repositories.OrderItemRepository;
import com.example.Cart_and_Order.repositories.OrderRepository;
import com.example.Cart_and_Order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

//    @Autowired
//    private  CartService cartService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Boolean> placeOrder(@RequestBody OrderDto orderDto ) {
        Boolean inserted = orderService.placeOrder(orderDto);

        if (inserted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/getAllOrdersById/{cartId}")
    public List<OrderResponseDto> getAllOrdersByCartId(@PathVariable("cartId")  String cartId) {
        Iterable<Order>  orders = orderRepository.findByCartId(cartId);

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            List<OrderItemResponseDto> orderItemResponseDtos = new ArrayList<>();
            for (String orderItemId : order.getOrderItemIds()) {
                OrderItem orderItem = orderItemRepository.findById(orderItemId).get();
                OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
                BeanUtils.copyProperties(orderItem, orderItemResponseDto);
                orderItemResponseDtos.add(orderItemResponseDto);
            }
            BeanUtils.copyProperties(order,orderResponseDto);
            orderResponseDto.setOrderItemResponseDtos(orderItemResponseDtos);

            orderResponseDtos.add(orderResponseDto);
        }


        return orderResponseDtos;
    }
}
