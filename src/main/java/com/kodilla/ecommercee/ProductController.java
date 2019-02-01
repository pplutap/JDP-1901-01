package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct( Long productId) {
        return new ProductDto(1L, "test name", "test description", 9.99, 2L);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(ProductDto productDto) {

    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(ProductDto productDto) {
        return new ProductDto(2L, "test name 2", "test description 2", 99.99, 12L);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(Long productId) {

    }
}
