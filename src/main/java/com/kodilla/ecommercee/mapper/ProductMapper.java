package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    private final GroupRepository groupRepository;

    @Autowired
    public ProductMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Product mapToProduct(ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice(),
                groupRepository.findById(productDto.getGroupId()).orElseThrow(GroupNotFoundException::new));
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

    public List<Product> mapToProductList(List<ProductDto> products) {
        return products.stream()
                .map(productDto -> new Product(productDto.getName(),
                        productDto.getDescription(), productDto.getPrice(),
                        groupRepository.findById(productDto.getGroupId()).orElseThrow(GroupNotFoundException::new)))
                .collect(Collectors.toList());
    }

    public List<Product> mapCsvReaderToProducts(CSVReader csvReader) {
        MappingStrategy mappingStrategy = new HeaderColumnNameMappingStrategy();
        mappingStrategy.setType(ProductDto.class);

        List<ProductDto> productDtos = new CsvToBeanBuilder<ProductDto>(csvReader)
                .withMappingStrategy(mappingStrategy).build().parse();

        return mapToProductList(productDtos);
    }
}
