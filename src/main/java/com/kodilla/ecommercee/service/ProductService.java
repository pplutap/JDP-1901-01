package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private ProductRepository productRepository;
    private GroupRepository groupRepository;

    public ProductService(ProductRepository productRepository, GroupRepository groupRepository) {
        this.productRepository = productRepository;
        this.groupRepository = groupRepository;
    }

    @Autowired


    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public Product  updateProduct(ProductDto updatedProduct, long id) throws GroupNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if (updatedProduct.getName() != null) product.setName(updatedProduct.getName());
        if (updatedProduct.getDescription() != null) product.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrice() != null) product.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getGroupId() != null) product.setGroup(groupRepository.findById(updatedProduct.getGroupId()).orElseThrow(GroupNotFoundException::new));

        return productRepository.save(product);
    }
}
