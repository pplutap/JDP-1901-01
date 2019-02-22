package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User banUser(long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setStatus("banned");

        return userRepository.save(user);
    }

    public User generateKey(long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        long key = new Random().nextLong() + user.getId();

        user.setUserKey(key);

        return userRepository.save(user);
    }
}
