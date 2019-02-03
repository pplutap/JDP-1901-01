package com.kodilla.ecommercee.domain;

import java.util.Map;

public class CartDto {
    private long id;
    private Map<Long, Integer> productsInCartQuantity;

    public CartDto(long id, Map<Long, Integer> productsInCartQuantity) {
        this.id = id;
        this.productsInCartQuantity = productsInCartQuantity;
    }

    public CartDto() {
    }

    public long getId() {
        return id;
    }

    public Map<Long, Integer> getProductsInCartQuantity() {
        return productsInCartQuantity;
    }
}
