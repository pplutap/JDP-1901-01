package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEntityTestSuite {

    @Autowired
    CartRepository cr;

    //Create
    @Test
    @Transactional
    public void testCreateCart() {

        //Given
        Product p1 = new Product("p1", "Description p1", new BigDecimal(55.55));
        Product p2 = new Product("p2", "Description p2", new BigDecimal(55.55));
        Product p3 = new Product("p3", "Description p3", new BigDecimal(55.55));
        Cart testCart = new Cart();

        //When
        testCart.getProducts().add(p1);
        testCart.getProducts().add(p2);
        testCart.getProducts().add(p3);
        cr.save(testCart);

        int quantity = cr.findAll().size();
        int expectedResult = 1;
        long productQuantityInDatabase = cr.findAll().stream()
                .flatMap(list -> list.getProducts().stream())
                .count();
        long expectedResult2 = 3;

        //Then
        Assert.assertEquals(expectedResult, quantity);
        Assert.assertEquals(expectedResult2, productQuantityInDatabase);
    }

    @Test
    @Transactional
    public void testGetCart() {

        //Given
        Product p1 = new Product("p1", "Description p1", new BigDecimal(55.55));
        Product p2 = new Product("p2", "Description p2", new BigDecimal(55.55));
        Product p3 = new Product("p3", "Description p3", new BigDecimal(55.55));
        Cart testCart = new Cart();

        //When
        testCart.getProducts().add(p1);
        testCart.getProducts().add(p2);
        testCart.getProducts().add(p3);

        cr.save(testCart);
        List<Cart> cartList = cr.findAll();

//        Double cartValue = cr.findById(1L).orElseThrow(CartNotFoundException::new)
//                .getProducts()
//                .stream()
//                .map(product -> product.getPrice())
//                .mapToDouble(BigDecimal::doubleValue)
//                .sum();
//
//        Double expected = 166.6;

        //Then

 //       Assert.assertEquals(expected, cartValue, 0.1);
        Assert.assertTrue(cartList.contains(testCart));
    }

    @Test
    @Transactional
    public void testUpdateCart() {

        //Given
        Product p1 = new Product("p1", "Description p1", new BigDecimal(55.55));
        Product p2 = new Product("p2", "Description p2", new BigDecimal(55.55));
        Product p3 = new Product("p3", "Description p3", new BigDecimal(55.55));
        Cart testCart = new Cart();

        //When
        testCart.getProducts().add(p1);
        testCart.getProducts().add(p2);
        testCart.getProducts().add(p3);

        cr.save(testCart);

        testCart.getProducts().add(new Product("p1", "Description p1", new BigDecimal(55.55)));
        cr.save(testCart);

        int cartProductListSizeAfterAdding = cr.findById(1L).orElseThrow(CartNotFoundException::new).getProducts().size();
        int actualValueOfCarts = cr.findAll().size();

        //Then
        Assert.assertEquals(4, cartProductListSizeAfterAdding);
        Assert.assertEquals(1, actualValueOfCarts);
    }

    @Test
    @Transactional
    public void testDeleteCart() {

        //Given
        Product p1 = new Product("p1", "Description p1", new BigDecimal(55.55));
        Product p2 = new Product("p2", "Description p2", new BigDecimal(55.55));
        Product p3 = new Product("p3", "Description p3", new BigDecimal(55.55));
        Cart testCart = new Cart();

        //When
        testCart.getProducts().add(p1);
        testCart.getProducts().add(p2);
        testCart.getProducts().add(p3);

        cr.save(testCart);
        int cartListSizeAfterAdding = cr.findAll().size();

        cr.delete(testCart);
        int actualValue = cr.findAll().size();

        //Then
        Assert.assertEquals(1, cartListSizeAfterAdding);
        Assert.assertEquals(0, actualValue);
    }
}
