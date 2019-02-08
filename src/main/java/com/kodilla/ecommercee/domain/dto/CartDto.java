package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;

import java.util.List;

public class CartDto {
    private long id;
    private List<Product> productList;

    public CartDto(long id, List<Product> products) {
        this.id = id;
        this.productList = products;
    }

    public CartDto() {
    }

    public long getId() {
        return id;
    }

    public List<Product> getProductsInCart() {
        return productList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductList(List<Product> list) {
        this.productList = list;
    }
}
