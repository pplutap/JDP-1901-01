package com.kodilla.ecommercee.domain.dto;

public class OrderDto {
    private Long id;
    private String value;

    public OrderDto() {
    }

    public OrderDto(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
