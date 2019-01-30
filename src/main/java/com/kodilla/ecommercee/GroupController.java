package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupMapper groupMapper;
//
//    @Autowired
//    private GroupService groupService;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {

        List<GroupDto> groups = new ArrayList<>();

        groups.add(new GroupDto(1, "Ubrania"));
        groups.add(new GroupDto(2, "Dodatki"));
        groups.add(new GroupDto(3, "Biżuteria"));
        groups.add(new GroupDto(4, "Obuwie"));

        return groups;
    }

    @PostMapping(value = "addGroup", consumes = APPLICATION_JSON_VALUE)
    public Group addGroup(@RequestBody GroupDto groupDto) {
        // groupService.saveGroup(groupMapper.mapToGroup(groupDto));
        return groupMapper.mapToGroup(groupDto);
    }

    @GetMapping(value = "id/{id}")
    public GroupDto getById(@PathVariable("id") long id) {
        // return groupMapper.mapToGroupDto(groupService.getById(id));
        return new GroupDto(id, ("Test id -> " + id));
    }

    @PostMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public String update(@RequestBody GroupDto groupDto) {
        // groupService.update(groupMapper.mapToGroup(groupDto));
        return "Updated ->" + groupDto.getName();
    }

}
