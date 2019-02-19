package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    private GroupRepository groupRepository;

    @Autowired
    public ProductMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Product mapToProduct(ProductDto productDto) throws GroupNotFoundException{
        if (groupRepository.findById(productDto.getGroupId()).isPresent()) {
            return new Product(productDto.getId(), productDto.getName(),
                    productDto.getDescription(), productDto.getPrice(),
                    groupRepository.findById(productDto.getGroupId()).get());
        }
        else throw new GroupNotFoundException();
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getId(), product.getName(),
                product.getDescription(), product.getPrice(), product.getGroup().getId());
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getId(), product.getName(),
                        product.getDescription(), product.getPrice(), product.getGroup().getId()))
                .collect(Collectors.toList());
    }
}
