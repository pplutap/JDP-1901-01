package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;

import java.util.List;

public class OrderDto {

    private Long id;
    private User user;
    private List<Product> products;

    public OrderDto(Long id, List<Product> products,  User user) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public OrderDto() {}

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
