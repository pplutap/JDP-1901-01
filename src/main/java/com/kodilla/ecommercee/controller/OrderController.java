package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper, UserService userService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getOrderList());
    }

    @GetMapping(value = "getOrder/{id}")
    public OrderDto getOrder(@PathVariable("id") Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrderById(orderId));
    }

    @PostMapping(value = "addOrder/{cartId}/{userId}")
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "User or Cart not Found")
    public void addOrder(@RequestParam long cartId, @RequestParam long userId) throws UserNotFoundException, CartNotFoundException {
        orderService.addOrder(cartId, userId);
    }

    @PutMapping(value = "updateOrder")
    public void updateOrder(@RequestBody OrderDto orderDto) {
        orderService.updateOrder(orderMapper.mapToOrder(orderDto));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestBody OrderDto orderDto) {
        orderService.deleteOrder(orderMapper.mapToOrder(orderDto));
    }

}
