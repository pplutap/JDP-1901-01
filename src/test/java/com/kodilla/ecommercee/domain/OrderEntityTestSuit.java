package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuit {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        int ordersTableSizeBeforeTest = orderRepository.findAll().size();

        //When
        orderRepository.save(new Order());
        orderRepository.save(new Order());
        orderRepository.save(new Order());

        //Then
        assertEquals(3, orderRepository.findAll().size() - ordersTableSizeBeforeTest);
    }

    @Transactional
    @Test(expected = OrderNotFoundException.class)
    public void testOrderNotFoundException() throws OrderNotFoundException {
        //Given
        Order order = orderRepository.save(new Order());

        //When
        orderRepository.delete(order);
        orderRepository.findById(order.getId()).orElseThrow(OrderNotFoundException::new);
    }

    @Transactional
    @Test
    public void testDeleteOrder() {
        //Given
        Order o1 = new Order();
        orderRepository.save(o1);
        int ordersSizeBeforeDelete = orderRepository.findAll().size();

        //When
        orderRepository.delete(o1);

        //Then
        assertEquals(ordersSizeBeforeDelete - 1, orderRepository.findAll().size());
    }

    @Transactional
    @Test
    public void testFindById() throws OrderNotFoundException{
        //Given
        Order o1 = new Order();
        orderRepository.save(o1);

        //When
        Order testOrder = orderRepository.findById(o1.getId()).orElseThrow(OrderNotFoundException::new);

        //Then
        assertEquals(o1, testOrder);
    }

    @Transactional
    @Test
    public void testAdd() {
        //Given
        Order order = orderService.addOrder(new Order());

        //When
        List<Order> orders = orderService.getOrderList();

        //Then
        assertTrue(orders.contains(order));
    }

//    @Transactional
//    @Test
//    public void testAddOrderWithCartAndUser() {
//        //Given
//        int usersTableSizeBefore = userService.getUserList().size();
//        int cartsTableSizeBefore = cartService.getCartList().size();
//        int ordersTableSizeBefore = orderService.getOrderList().size();
//        Cart cart = cartService.addCart(new Cart());
//        User user = userService.addUser(new User("name", "status", 123L));
//
//        //When
//        Order order = orderService.addOrder(new Order(cart, user));
//
//        //Then
//        assertEquals(ordersTableSizeBefore + 1, orderService.getOrderList().size());
//        assertEquals(usersTableSizeBefore + 1, userService.getUserList().size());
//        assertEquals(cartsTableSizeBefore + 1, cartService.getCartList().size());
//        assertTrue(cartService.getCartList().contains(cart));
//        assertTrue(userService.getUserList().contains(user));
//    }

}