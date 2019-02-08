package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartMapper cartMapper;

    @Autowired
    public CartController(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @GetMapping(value = "getProductsInCart/{id}")
    public CartDto getProductsInCart(@PathVariable("id") long cartId) throws CartNotFoundException {
        return new CartDto(cartId, new ArrayList<>());
    }

    @PutMapping(value = "updateCart")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartDto;
    }

    @DeleteMapping(value = "removeProductFromCart/{cart_id}/{product_id}")
    public void removeProductFromCart(@PathVariable("cart_id") long cartId, @PathVariable("product_id") long productId) {

    }

    @PostMapping(value = "createOrder/{cart_id}")
    public OrderDto createOrder(@PathVariable("cart_id")long cartId) {
        return new OrderDto();
    }

    @PostMapping(value = "createCart")
    public CartDto addCart() {
        return new CartDto(1, new ArrayList<>());
    }
}
