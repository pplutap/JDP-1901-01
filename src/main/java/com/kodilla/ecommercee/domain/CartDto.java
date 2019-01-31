package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private long Id;
    private Map<Long, Integer> productsInCart;
}
