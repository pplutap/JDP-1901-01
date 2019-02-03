package com.kodilla.ecommercee.domain.dto;

import java.util.HashSet;
import java.util.Set;

public class GroupDto {

    private long id;
    private String name;
    private Set<Product> productsInGroup = new HashSet<>();

    public GroupDto(long id, String name, Set<Product> productsInGroup) {
        this.id = id;
        this.name = name;
        this.productsInGroup = productsInGroup;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProductsInGroup() {
        return productsInGroup;
    }
}

