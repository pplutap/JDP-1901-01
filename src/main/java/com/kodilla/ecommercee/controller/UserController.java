package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userMapper.mapToUser(userDto));
    }

    @PatchMapping("{id}")
    public UserDto banUser(@PathVariable long id) {
        return userMapper.mapToUserDto(userService.banUser(id));
    }

    @PatchMapping("key/{id}")
    public UserDto generateKey(@PathVariable long id) {
        return userMapper.mapToUserDto(userService.generateKey(id));
    }
}
