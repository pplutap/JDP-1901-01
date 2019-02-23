package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.FileStorageService;
import com.kodilla.ecommercee.service.ProductService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final FileStorageService storageService;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper, FileStorageService storageService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.storageService = storageService;
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
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        Path filePath = storageService.storeFile(file);
        System.out.println(filePath);

        Map<String, String> mapping = new HashMap<>();
        mapping.put("Name", "name");
        mapping.put("Description", "description");
        mapping.put("Price", "price");
        mapping.put("Group", "group");

        HeaderColumnNameTranslateMappingStrategy<Product> strategy =
                new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Product.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(filePath.toString()));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        List<Product> list = csvToBean.parse(strategy, csvReader);

        for (Product e : list) {
            System.out.println(e);
        }
    }
}
