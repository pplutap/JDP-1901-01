package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;

import java.util.List;

public class CartDto {
    private long id;
    private List<Product> products;

    public CartDto(long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public CartDto() {
    }

    public long getId() {
        return id;
    }

    public List<Product> getProductsInCart() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> list) {
        this.products = list;
    }
}
