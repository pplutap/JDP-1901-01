package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
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

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Test
    public void testSave() {
        //Given
        long sizeBeforeTest = userRepository.count();

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
        Assert.assertEquals(4L, userRepository.count() - sizeBeforeTest);
    }

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        int sizeBeforeTest = userRepository.findAll().size();

        User user = new User("jane", "user", 23456L);
        User user2 = new User("jim", "user2", 4232L);
        User user3 = new User("judy", "admin", 0L);

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        List<User> users = userRepository.findAll();

        //Then
        Assert.assertEquals(3, users.size() - sizeBeforeTest);
        Assert.assertTrue(users.contains(user));
        Assert.assertTrue(users.contains(user2));
        Assert.assertTrue(users.contains(user3));

    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        User user = new User("jim", "user2", 4232L);
        User user2 = new User("jane", "user", 23456L);
        User user3 = new User("judy", "admin", 0L);

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        Optional<User> testUser = userRepository.findById(user2.getId());

        //Then
        Assert.assertTrue(testUser.isPresent());
        Assert.assertEquals(Optional.of(user2), testUser);
        Assert.assertEquals("jane", testUser.get().getUsername());
        Assert.assertEquals("user", testUser.get().getStatus());
        Assert.assertEquals(23456L, testUser.get().getUserKey(), 0.0);
    }

    @Transactional
    @Test
    public void testRelationWithOrder() {
        //Given
        Order order = new Order();
        Order order2 = new Order();

        orderRepository.save(order);
        orderRepository.save(order2);

        User user = new User("jane", "user", 23456L);
        User user2 = new User("jim", "user2", 4232L);
        User user3 = new User("john", "test1", 1L);
        User user4 = new User("judy", "admin", 0L);

        int numberOfOrders = user2.getOrders().size();

        user.getOrders().add(order);
        user2.getOrders().add(order2);
        user3.getOrders().add(order);
        user3.getOrders().add(order2);

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        long userId = user.getId();
        long user2Id = user2.getId();
        long user3Id = user3.getId();
        long user4Id = user4.getId();

        //When
        List<Order> orders = userRepository.findById(user3Id).get().getOrders();

        //Then
        Assert.assertEquals(2, orders.size() - numberOfOrders);
        Assert.assertTrue(userRepository.findById(userId).get().getOrders().contains(order));
        Assert.assertTrue(userRepository.findById(user2Id).get().getOrders().contains(order2));
        Assert.assertTrue(userRepository.findById(user4Id).get().getOrders().isEmpty());
    }
}