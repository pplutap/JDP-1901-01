package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.FileService;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final FileService fileService;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper, FileService fileService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.fileService = fileService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getProductList());
    }

    @GetMapping(value = "{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) {
        return productMapper.mapToProductDto(productService.getProductById(productId));
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto)  {
        productService.addProduct(productMapper.mapToProduct(productDto));
    }

    @PatchMapping(value = "{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Long productId) {
        return productMapper.mapToProductDto(productService.updateProduct(productDto, productId));
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }

    @PostMapping("/uploadFile")
    public void addProductsFromUploadedFile(@RequestParam("file") MultipartFile file) {
        List<Product> products = productMapper.mapCsvReaderToProducts(fileService.readCsv(fileService.storeFile(file)));

        for (Product p : products) {
            productService.addProduct(p);
        }
    }
}
