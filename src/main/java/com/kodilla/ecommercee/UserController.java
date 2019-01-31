package com.kodilla.ecommercee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {
    private long key;

    private UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("createUser")
    public User createUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUser(userDto);
    }

    @GetMapping("banUser")
    public void banUser(Long userId) {

    }

    @GetMapping("generateKey")
    public Long generateKey() {
        return key = new Random().nextLong();
    }

}
