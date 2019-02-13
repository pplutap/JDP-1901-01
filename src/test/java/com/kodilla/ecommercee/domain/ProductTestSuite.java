package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Test
    public void testSavingProduct() {
        //given
        Product testProduct = new Product("Shirt", "white shirt", BigDecimal.valueOf(5.20));

        //when
        productRepository.save(testProduct);

        //then
        Assert.assertEquals(1L, productRepository.count());
    }

    @Transactional
    @Test
    public void testFindById() {
        //given
        Product testProduct = new Product("Shirt", "white shirt", BigDecimal.valueOf(5.20));

        //when
        productRepository.save(testProduct);
        Long id = testProduct.getId();
        Optional<Product> loadedProduct = productRepository.findById(id);

        //then
        Assert.assertTrue(loadedProduct.isPresent());
        Assert.assertEquals("Shirt", loadedProduct.get().getName());
        Assert.assertEquals(BigDecimal.valueOf(5.20), loadedProduct.get().getPrice());

    }

    @Transactional
    @Test
    public void testRelationWithGroups() {
        //given
        Group clothes = new Group();
        Group food = new Group();

        Product trousers = new Product("trousers", "normal trousers", BigDecimal.valueOf(22.90));
        Product socks = new Product("socks", "clean socks", BigDecimal.valueOf(2.99));
        Product tomatoe = new Product("tomato", "red tomato", BigDecimal.valueOf(0.99));
        Product onion = new Product("onion", "just onion", BigDecimal.valueOf(0.25));

        /**
         * Can't test setting group without method being public
         */
    }

    @Transactional
    @Test
    public void testFindAll() {
        //given
        Product testProductOne = new Product("Shirt", "white shirt", BigDecimal.valueOf(5.20));
        Product testProductTwo = new Product("Hat", "fancy hat", BigDecimal.valueOf(8.99));
        Product testProductThree = new Product("Pants", "panties", BigDecimal.valueOf(3.00));
        Product testProductFour = new Product("Scarf", "nice scarf", BigDecimal.valueOf(7.05));

        productRepository.save(testProductOne);
        productRepository.save(testProductTwo);
        productRepository.save(testProductThree);
        productRepository.save(testProductFour);

        //when
        /**
         * This method should work without need of casting
         */
        List<Product> loadedProducts = (List<Product>)productRepository.findAll();

        //then
        Assert.assertEquals(4, loadedProducts.size());
        Assert.assertTrue(loadedProducts.contains(testProductOne));
        Assert.assertTrue(loadedProducts.contains(testProductTwo));
        Assert.assertTrue(loadedProducts.contains(testProductThree));
        Assert.assertTrue(loadedProducts.contains(testProductFour));
    }

    @Test
    public void testingDeletingProduct() {
        //given
        Product testProduct = new Product("Shirt", "white shirt", BigDecimal.valueOf(5.20));
        productRepository.save(testProduct);

        //when
        productRepository.delete(testProduct);

        //then
        Assert.assertEquals(0L, productRepository.count());

    }

    @Test
    public void testingDeletingProductById() {
        //given
        Product testProduct = new Product("Shirt", "white shirt", BigDecimal.valueOf(5.20));
        productRepository.save(testProduct);
        Long id = testProduct.getId();

        //when
        productRepository.deleteById(id);

        //then
        Assert.assertEquals(0L, productRepository.count());
    }

    @Transactional
    @Test
    public void testCheckExistenceById() {
        //given
        Product testProduct = new Product("Shirt", "white shirt", BigDecimal.valueOf(5.20));
        productRepository.save(testProduct);
        Long id = testProduct.getId();

        //when
        boolean exists = productRepository.existsById(id);

        //then
        Assert.assertTrue(exists);
    }
}
