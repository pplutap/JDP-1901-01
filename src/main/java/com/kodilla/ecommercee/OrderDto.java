package com.kodilla.ecommercee;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String value;

    public OrderDto(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
