package com.kodilla.ecommercee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    //@Autowired
    //private DbService service;

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(value="getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
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

}
