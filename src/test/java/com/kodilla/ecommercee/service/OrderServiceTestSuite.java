package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestSuite {
    
    @Autowired
    OrderService orderService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @Transactional
    public void AddUserTest() throws UserNotFoundException {
        //Given
        User user = new User("Jan Kowalski", "YES", 1L);
        Cart cart = new Cart();

        userRepository.save(user);
        cartRepository.save(cart);
        int orders = orderRepository.findAll().size();

        //When
        orderService.addOrder(cart.getId(), user.getId());
        int result = orderRepository.findAll().size();

        //Then
        Assert.assertEquals(orders + 1, result);
    }

}
