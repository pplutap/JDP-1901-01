package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return new UserDto(userDto.getId(), userDto.getUsername(), "-1", userDto.getUserKey());
    }

    @GetMapping("generateKey")
    public Long generateKey(@RequestParam long userId) {
        long key = new Random().nextLong();
        return key + userId;
    }

}
