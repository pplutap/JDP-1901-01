package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.exception.OrderNotFoundException;
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
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        int ordersTableSizeBeforeTest = orderService.getOrderList().size();

        //When
        orderService.addOrder(new Order());
        orderService.addOrder(new Order());
        orderService.addOrder(new Order());

        //Then
        assertEquals(3, orderService.getOrderList().size() - ordersTableSizeBeforeTest);
    }

    @Transactional
    @Test(expected = OrderNotFoundException.class)
    public void testOrderNotFoundException() throws OrderNotFoundException {
        //Given
        Order order = orderService.addOrder(new Order());

        //When
        orderService.deleteOrder(order);
        orderService.getOrderById(order.getId());
    }

    @Transactional
    @Test
    public void testDeleteOrder() {
        //Given
        Order order = orderService.addOrder(new Order());
        int ordersSizeBeforeDelete = orderService.getOrderList().size();

        //When
        orderService.deleteOrder(order);

        //Then
        assertEquals(ordersSizeBeforeDelete - 1, orderService.getOrderList().size());
    }

    @Transactional
    @Test
    public void testFindById() throws OrderNotFoundException{
        //Given
        Order order = orderService.addOrder(new Order());

        //When
        Order testOrder = orderService.getOrderById(order.getId());

        //Then
        assertEquals(order, testOrder);
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

    @Transactional
    @Test
    public void testAddOrderWithCartAndUser() {
        //Given
        int usersTableSizeBefore = userService.getUserList().size();
        int cartsTableSizeBefore = cartService.getCartList().size();
        int ordersTableSizeBefore = orderService.getOrderList().size();

        Cart cart = cartService.addCart(new Cart());
        User user = userService.addUser(new User());

        //When
        orderService.addOrder(new Order());

        //Then
        assertEquals(ordersTableSizeBefore + 1, orderService.getOrderList().size());
        assertEquals(usersTableSizeBefore + 1, userService.getUserList().size());
        assertEquals(cartsTableSizeBefore + 1, cartService.getCartList().size());
    }

}