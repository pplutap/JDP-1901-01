package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(final Long id) {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public Group updateGroup(GroupDto groupDtoAfterUpdate, Long groupIdToUpdate) {
        Group group = groupRepository.findById(groupIdToUpdate).orElseThrow(GroupNotFoundException::new);
        if(groupDtoAfterUpdate.getName().length() > 0) {
            group.setName(groupDtoAfterUpdate.getName());
        }
        return groupRepository.save(group);

    }

}
