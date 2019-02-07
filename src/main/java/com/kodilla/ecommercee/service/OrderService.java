package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderService() {}

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
