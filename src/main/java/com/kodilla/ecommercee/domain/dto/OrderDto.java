package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;

import java.util.List;

public class OrderDto {

    private Long id;
    private User user;
    private List<Product> productList;

    public OrderDto(Long id, List<Product> productList,  User user) {
        this.id = id;
        this.user = user;
        this.productList = productList;
    }

    public OrderDto() {}

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
