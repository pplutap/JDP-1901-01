package com.kodilla.ecommercee.domain;

import java.util.Map;

public class Cart {
    private long Id;
    private Map<Long, Integer> productsInCart;

    public Cart(long id, Map<Long, Integer> productsInCart) {
        Id = id;
        this.productsInCart = productsInCart;
    }

    public Cart() {
    }

    public long getId() {
        return Id;
    }

    public Map<Long, Integer> getProductsInCart() {
        return productsInCart;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setProductsInCart(Map<Long, Integer> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
