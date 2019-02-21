package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderMapper orderMapper;
    private OrderService orderService;

    @Autowired
    public OrderController(OrderMapper orderMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

    @GetMapping(value="getOrders")
    public List<OrderDto> getOrders() {

        List<OrderDto> list = new ArrayList<>();
        list.add(new OrderDto());
        list.add(new OrderDto());

        return list;
    }

    @GetMapping(value="getOrder/{id}")
    public OrderDto getOrder(@PathVariable("id") Long orderId) {
        return new OrderDto();
    }

    @PostMapping(value="addOrder", consumes = APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody OrderDto orderDto) {

    }

    @PutMapping(value="updateOrder")
    public void updateOrder(@RequestBody OrderDto orderDto) {

    }

    @DeleteMapping(value="deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") Long orderId) {

    }

    @PostMapping
    public OrderDto createOrder(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        return orderMapper.mapToOrderDto(orderService.addOrder(new Order(cart, user)));
    }

}
