package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuit {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        long ordersTableSizeBeforeTest = orderRepository.count();
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();


        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        //Then
        assertEquals(3, orderRepository.count() - ordersTableSizeBeforeTest);
        assertTrue(orderRepository.findAll().contains(order1));
        assertTrue(orderRepository.findAll().contains(order2));
        assertTrue(orderRepository.findAll().contains(order3));
    }

    @Transactional
    @Test
    public void testDeleteOrder() {
        //Given
        Order order = orderRepository.save(new Order());
        long ordersSizeBeforeDelete = orderRepository.count();

        //When
        orderRepository.delete(order);

        //Then
        assertEquals(ordersSizeBeforeDelete - 1, orderRepository.count());
        assertFalse(orderRepository.findAll().contains(order));
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Order order = orderRepository.save(new Order());

        //When
        Order testOrder = orderRepository.findById(order.getId()).get();

        //Then
        assertEquals(order, testOrder);
    }

    @Transactional
    @Test
    public void testAdd() {
        //Given
        Order order = orderRepository.save(new Order());

        //When
        List<Order> orders = orderRepository.findAll();

        //Then
        assertTrue(orders.contains(order));
    }

    @Transactional
    @Test
    public void testAddOrderWithCartAndUser() {
        //Given
        long usersTableSizeBefore = userRepository.count();
        long cartsTableSizeBefore = cartRepository.count();
        long ordersTableSizeBefore = orderRepository.count();
        Cart cart = cartRepository.save(new Cart());
        User user = userRepository.save(new User("name", "status", 123L));

        //When
        Order order = orderRepository.save(new Order(cart, user));
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        user.setOrders(orders);

        //Then
        assertEquals(ordersTableSizeBefore + 1, orderRepository.count());
        assertEquals(usersTableSizeBefore + 1, userRepository.count());
        assertEquals(cartsTableSizeBefore + 1, cartRepository.count());
        assertTrue(cartRepository.findAll().contains(cart));
        assertTrue(userRepository.findAll().contains(user));
        assertTrue(orderRepository.findAll().contains(order));
        assertEquals(orderRepository.findById(order.getId()).get().getCart().getId(), cart.getId());
        assertEquals(orderRepository.findById(order.getId()).get().getUser().getId(), user.getId());
        assertTrue(userRepository.findById(user.getId()).get().getOrders().contains(order));

    }

}