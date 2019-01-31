package com.kodilla.ecommercee;

import lombok.Getter;

@Getter
public class OrderDto {
    private Long id;
    private String value;

    public OrderDto() {
    }

    public OrderDto(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
