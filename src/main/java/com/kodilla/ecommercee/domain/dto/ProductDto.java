package com.kodilla.ecommercee.domain.dto;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class ProductDto {
    private Long id;
    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Description")
    private String description;
    @CsvBindByName(column = "Price")
    private BigDecimal price;
    @CsvBindByName(column = "Group")
    private Long groupId;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, BigDecimal price, Long groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getGroupId() {
        return groupId;
    }
}
