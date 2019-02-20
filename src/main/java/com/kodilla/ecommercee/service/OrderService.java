package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserService userService, CartService cartService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.cartService = cartService;
    }

    public void addOrder(Long cartId, Long userId) throws UserNotFoundException, CartNotFoundException {
        orderRepository.save(new Order(cartService.getCartById(cartId), userService.getUserById(userId)));
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    public Order getOrderById(long id) throws OrderNotFoundException {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);

    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
