package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carts")
@CrossOrigin("*")
public class CartController {
    private final CartMapper cartMapper;

    @Autowired
    public CartController(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @GetMapping(value = "getProductsInCart/{id}")
    public CartDto getProductsInCart(@PathVariable("id") long cartId) throws CartNotFoundException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("banan", "żółty banan", new BigDecimal("12,33")));
        products.add(new Product("winogrono", "białe winogrono", new BigDecimal("33,33")));
        return new CartDto(cartId, products);
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
