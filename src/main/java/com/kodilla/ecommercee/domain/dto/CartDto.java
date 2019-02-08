package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;

import java.util.List;

public class CartDto {
    private long id;
    private List<Product> productsInCartQuantity;

    public CartDto(long id, List<Product> productsInCartQuantity) {
        this.id = id;
        this.productsInCartQuantity = productsInCartQuantity;
    }

    public CartDto() {
    }

    public long getId() {
        return id;
    }

    public List<Product> getProductsInCartQuantity() {
        return productsInCartQuantity;
    }
}
