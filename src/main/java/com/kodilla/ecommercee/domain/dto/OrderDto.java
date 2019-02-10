package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;

public class OrderDto {

    private Long id;
    private User user;
    private Cart cart;

    public OrderDto(Long id, Cart cart, User user) {
        this.id = id;
        this.user = user;
        this.cart = cart;
    }

    public OrderDto() {}

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
