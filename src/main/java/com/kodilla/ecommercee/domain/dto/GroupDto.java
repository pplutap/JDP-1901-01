package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class GroupDto {
    private long id;
    private String name;
    private Set<Product> products = new HashSet<>();

    public GroupDto(long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public GroupDto() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
