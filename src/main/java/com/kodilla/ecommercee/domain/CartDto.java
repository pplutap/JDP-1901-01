package com.kodilla.ecommercee.domain;

import java.util.Map;

public class CartDto {
    private long Id;
    private Map<Long, Integer> productsInCart;

    public CartDto(long id, Map<Long, Integer> productsInCart) {
        Id = id;
        this.productsInCart = productsInCart;
    }

    public CartDto() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Map<Long, Integer> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(Map<Long, Integer> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
