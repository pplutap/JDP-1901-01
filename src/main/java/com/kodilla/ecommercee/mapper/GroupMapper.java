package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import org.springframework.stereotype.Service;

@Service
public class GroupMapper {

    public Group mapToGroup(GroupDto groupDto) {
        return new Group(groupDto.getId(), groupDto.getName(), groupDto.getProductsInGroup());
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(), group.getName(), group.getProductsInGroup());
    }
}
