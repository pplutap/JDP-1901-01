package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

        groups.add(new GroupDto(1, "Ubrania"));
        groups.add(new GroupDto(2, "Dodatki"));
        groups.add(new GroupDto(3, "Biżuteria"));
        groups.add(new GroupDto(4, "Obuwie"));

        return groups;
    }

    @PostMapping(value = "addGroup")
    public Group addGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroup(groupDto);
    }

    @GetMapping(value = "id/{id}")
    public GroupDto getById(@PathVariable("id") long id) {
        return new GroupDto(id, ("Test id -> " + id));
    }

    @PutMapping(value = "update")
    public String update(@RequestBody GroupDto groupDto) {
        return "Updated ->" + groupDto.getName();
    }

}
