package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getProductList());
    }

    @GetMapping(value = "getProduct/{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(productService.getProductById(productId).orElseThrow(ProductNotFoundException::new));
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        productService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @PatchMapping(value = "{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Long productId) throws ProductNotFoundException, GroupNotFoundException {
        return productMapper.mapToProductDto(productService.updateProduct(productDto, productId));
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }
}
