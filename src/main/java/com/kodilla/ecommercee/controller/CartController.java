package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/V1/cart")
public class CartController {
    private final CartMapper cartMapper;

    public CartController(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @GetMapping(value = "getProductsInCart")
    public CartDto getProductsInCart(long cartId) throws CartNotFoundException {
        return new CartDto();
    }

    @PutMapping(value = "updateCart")
    public CartDto updateCart(long cartId, long productId, int quantity) {
        Map<Long, Integer> productsInCartQuantity = new HashMap<>();
        productsInCartQuantity.put(productId, quantity);
        return new CartDto();
    }

    @DeleteMapping(value = "removeProductFromCart")
    public void removeProductFromCart(long cartId, long productId) {

    }

    @PostMapping(value = "createOrder")
    public OrderDto createOrder(Long cartId) {
        return new OrderDto();
    }

    @PostMapping(value = "createCart")
    public CartDto createCart() {
        return new CartDto();
    }
}
