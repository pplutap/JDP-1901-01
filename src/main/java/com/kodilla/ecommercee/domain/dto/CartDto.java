package com.kodilla.ecommercee.domain.dto;

import java.util.List;

public class CartDto {
    private long id;
    private List<ProductDto> products;

    public CartDto(long id, List<ProductDto> products) {
        this.id = id;
        this.products = products;
    }

    public CartDto() {
    }

    public long getId() {
        return id;
    }

    public List<ProductDto> getProductsInCart() {
        return products;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
