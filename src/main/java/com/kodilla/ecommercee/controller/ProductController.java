package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto(4L, "test name 3", "test description 3", new BigDecimal("19.32"), 43L));
        products.add(new ProductDto(8L, "test name 4", "test description 4",  new BigDecimal("424.12"), 23L));

        return products;
    }

    @GetMapping(value = "getProduct/{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) {
        return new ProductDto(1L, "test name", "test description", new BigDecimal("9.99"), 2L);
    }

    @PostMapping(value = "addProduct")
    public void addProduct(@RequestBody ProductDto productDto) {

    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @DeleteMapping(value = "deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {

    }
}
