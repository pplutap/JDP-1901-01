package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(value="getOrders")
    public List<OrderDto> getOrders() {

        List<OrderDto> list = new ArrayList<>();
        list.add(new OrderDto(2L, "test 2"));
        list.add(new OrderDto(3L, "test 3"));


        return list;
    }

    @GetMapping(value="getOrder/{id}")
    public OrderDto getOrder(@PathVariable("id") Long orderId) {
        return new OrderDto(1L, "test value");
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

}