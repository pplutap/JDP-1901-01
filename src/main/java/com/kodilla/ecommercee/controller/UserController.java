package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("addUser")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping("banUser")
    public UserDto banUser(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUsername(), "-1", userDto.getUserKey(),userDto.getOrders());
    }

    @GetMapping("generateKey")
    public Long generateKey(@RequestParam long userId) {
        long key = new Random().nextLong();
        return key + userId;
    }

}
