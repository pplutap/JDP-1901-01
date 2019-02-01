package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {
    private long key;

    @PostMapping("addUser")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping("banUser")
    public UserDto banUser(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUsername(), "-1", userDto.getUserKey());
    }

    @GetMapping("generateKey")
    public String generateKey(@RequestParam long userId) {
        key = new Random().nextLong();
        return String.valueOf(key + userId);
    }

}
