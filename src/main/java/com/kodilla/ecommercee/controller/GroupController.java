package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupMapper groupMapper;

    @Autowired
    public GroupController(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {

        List<GroupDto> groups = new ArrayList<>();
        return groups;
    }

    @PostMapping(value = "addGroup")
    public Group addGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroup(groupDto);
    }

    @GetMapping(value = "id/{id}")
    public GroupDto getById(@PathVariable("id") long id) {
        return new GroupDto(id, "Test id -> " + id, new HashSet<>());
    }

    @PutMapping(value = "update")
    public String update(@RequestBody GroupDto groupDto) {
        return "Updated ->" + groupDto.getName();
    }

}
