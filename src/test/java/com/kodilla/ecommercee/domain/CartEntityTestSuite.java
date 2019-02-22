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

        int quantityBefore = cr.findAll().size();

        cr.save(testCart);

        int quantityAfter = cr.findAll().size();

        List<Cart> allCarts = cr.findAll();

        //Then
        Assert.assertEquals(quantityBefore, quantityAfter - 1);
        Assert.assertTrue(allCarts.contains(testCart));
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
        Cart expectedCart = cr.findById(testCart.getId()).orElseThrow(CartNotFoundException::new);

        Assert.assertEquals(testCart, expectedCart);
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

        int cartProductListSizeAfterAdding = cr.findById(testCart.getId()).orElseThrow(CartNotFoundException::new).getProducts().size();

        //Then
        Assert.assertEquals(4, cartProductListSizeAfterAdding);
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

        int cartListSizeBefore = cr.findAll().size();

        cr.save(testCart);
        int cartListSizeAfterAdding = cr.findAll().size();

        cr.delete(testCart);
        int actualValue = cr.findAll().size();

        //Then
        Assert.assertEquals(cartListSizeBefore + 1, cartListSizeAfterAdding);
        Assert.assertEquals(cartListSizeBefore, actualValue);
    }
}
