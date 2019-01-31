package com.kodilla.ecommercee;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getStatus(),
                userDto.getUserKey());
    }
}
