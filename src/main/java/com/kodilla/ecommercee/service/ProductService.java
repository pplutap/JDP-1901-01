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

@Component
public class ProductService {
    private final ProductRepository productRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, GroupRepository groupRepository) {
        this.productRepository = productRepository;
        this.groupRepository = groupRepository;
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public void addProduct(Product product) throws GroupNotFoundException {
        productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public Product  updateProduct(ProductDto updatedProduct, long id) throws GroupNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if (updatedProduct.getName() != null) {
            product.setName(updatedProduct.getName());
        }
        if (updatedProduct.getDescription() != null) {
            product.setDescription(updatedProduct.getDescription());
        }
        if (updatedProduct.getPrice() != null) {
            product.setPrice(updatedProduct.getPrice());
        }
        if (updatedProduct.getGroupId() != null) {
            product.setGroup(groupRepository.findById(updatedProduct.getGroupId()).orElseThrow(GroupNotFoundException::new));
        }

        return productRepository.save(product);
    }
}
