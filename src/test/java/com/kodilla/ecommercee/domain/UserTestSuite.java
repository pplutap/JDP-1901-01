package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Test
    public void testSave() {
        //Given
        User user = new User("jane", "user", 23456L);
        User user2 = new User("jim", "user2", 4232L);
        User user3 = new User("john", "test1", 1L);
        User user4 = new User("judy", "admin", 0L);

        //When
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        //Then
        Assert.assertEquals(4L, userRepository.count());
    }

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        User user = new User("jane", "user", 23456L);
        User user2 = new User("jim", "user2", 4232L);
        User user4 = new User("judy", "admin", 0L);

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user4);

        //When
        List<User> users = userRepository.findAll();

        //Then
        Assert.assertEquals(3, users.size());

    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        User user2 = new User("jim", "user2", 4232L);

        userRepository.save(user2);

        //When
        long testId = user2.getId();
        Optional<User> testUser = userRepository.findById(testId);

        //Then
        Assert.assertEquals(Optional.of(user2), testUser);
    }
}