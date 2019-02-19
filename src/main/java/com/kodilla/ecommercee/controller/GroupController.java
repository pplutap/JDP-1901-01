package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupMapper groupMapper;
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupMapper groupMapper, GroupService groupService) {
        this.groupMapper = groupMapper;
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }

    @PostMapping
    public void addGroup(@RequestBody GroupDto groupDto) {
        groupService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @GetMapping(value = "{id}")
    public GroupDto getById(@PathVariable("id") long id) {
        return groupMapper.mapToGroupDto(groupService.getGroupById(id));
    }

    @PatchMapping(value = "{id}")
    public GroupDto update(@RequestBody GroupDto groupDto, @PathVariable("id") long id) {
        return groupMapper.mapToGroupDto(groupService.updateGroup(groupDto, id));
    }

}
