package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupMapper {
   private ProductRepository productRepository;

   @Autowired
   public GroupMapper(ProductRepository productRepository) {
       this.productRepository = productRepository;
   }

    public Group mapToGroup(GroupDto groupDto) {
        Set<Product> products = productRepository.findAll().stream()
                .filter(e -> e.getGroup().getId() == groupDto.getId())
                .collect(Collectors.toSet());
        return new Group(groupDto.getId(), groupDto.getName(), products);
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(), group.getName());
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groups) {
        return groups.stream()
                .map(e -> new GroupDto(e.getId(), e.getName()))
                .collect(Collectors.toList());
    }
}
