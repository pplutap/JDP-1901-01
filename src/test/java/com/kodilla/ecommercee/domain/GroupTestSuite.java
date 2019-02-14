package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuite {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Test
    public void testSave() {
        //Given
        long initialNumberOfGroups = groupRepository.count();
        Group group1 = new Group();
        Group group2 = new Group();
        group1.setName("Test group 1");
        group2.setName("Test group 2");

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);

        //Then
        Assert.assertEquals(initialNumberOfGroups + 2L, groupRepository.count());
        Assert.assertTrue(groupRepository.findAll().contains(group1));
        Assert.assertTrue(groupRepository.findAll().contains(group2));
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Group group1 = new Group();
        Group group2 = new Group();
        group1.setName("Test group 1");
        group2.setName("Test group 2");

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        long group1Id = group1.getId();
        long group2Id = group2.getId();

        //Then
        Assert.assertEquals(group1, groupRepository.findById(group1Id).get());
        Assert.assertEquals(group2, groupRepository.findById(group2Id).get());
        Assert.assertNotEquals(group1, groupRepository.findById(group2Id).get());
    }

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        long initialNumberOfGroups = groupRepository.count();

        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();
        Group group4 = new Group();
        group1.setName("Test group 1");
        group2.setName("Test group 2");
        group3.setName("Test group 3");
        group4.setName("Test group 4");

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group4);

        //Then
        Assert.assertEquals(initialNumberOfGroups + 3L, groupRepository.findAll().size());
        Assert.assertTrue(groupRepository.findAll().contains(group1));
        Assert.assertTrue(groupRepository.findAll().contains(group2));
        Assert.assertFalse(groupRepository.findAll().contains(group3));
        Assert.assertTrue(groupRepository.findAll().contains(group4));
    }

    @Transactional
    @Test
    public void testRelationWithProduct() {
        //Given
        Product product1 = new Product("product 1", "test product 1", new BigDecimal("10.00"));
        Product product2 = new Product("product 2", "test product 2", new BigDecimal("20.00"));
        Product product3 = new Product("product 3", "test product 3", new BigDecimal("30.00"));
        Product product4 = new Product("product 4", "test product 4", new BigDecimal("40.00"));
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

        Group group1 = new Group();
        group1.setName("Test group 1");
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        Group group2 = new Group();
        group2.setName("Test group 2");
        group2.getProducts().add(product3);
        group2.getProducts().add(product4);

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        long group1Id = group1.getId();
        long group2Id = group2.getId();

        //Then
        Assert.assertTrue(groupRepository.findById(group1Id).get().getProducts().contains(product1));
        Assert.assertTrue(groupRepository.findById(group1Id).get().getProducts().contains(product2));
        Assert.assertTrue(groupRepository.findById(group2Id).get().getProducts().contains(product3));
        Assert.assertTrue(groupRepository.findById(group2Id).get().getProducts().contains(product4));
        Assert.assertTrue(groupRepository.findById(group1Id).get().getProducts().contains(product1));
        Assert.assertFalse(groupRepository.findById(group1Id).get().getProducts().contains(product3));
        Assert.assertTrue(groupRepository.findById(group1Id).get().getProducts().contains(product1));
        Assert.assertFalse(groupRepository.findById(group2Id).get().getProducts().contains(product2));
    }

    @Transactional
    @Test
    public void testDeleteGroup() {
        //Given
        long initialNumberOfGroups = groupRepository.count();
        Group group1 = new Group();
        group1.setName("Test group 1");
        Group group2 = new Group();
        group2.setName("Test group 2");
        Group group3 = new Group();
        group3.setName("Test group 3");

        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);

        //When

        groupRepository.delete(group1);
        groupRepository.delete(group3);
        long numberOfGroupsAfterDeletes = groupRepository.count();

        //Then
        Assert.assertEquals(initialNumberOfGroups + 1L, numberOfGroupsAfterDeletes);
    }

    @Test
    public void testDeleteGroupById() {
        //Given
        long initialNumberOfGroups = groupRepository.count();
        Group group1 = new Group();
        group1.setName("Test group 1");
        Group group2 = new Group();
        group2.setName("Test group 2");

        groupRepository.save(group1);
        groupRepository.save(group2);
        long numberOfGroupsAfterSaves = groupRepository.count();

        //When
        groupRepository.deleteById(group1.getId());
        groupRepository.deleteById(group2.getId());
        long numberOfGroupsAfterDeletes = groupRepository.count();

        //Then
        Assert.assertEquals(initialNumberOfGroups , numberOfGroupsAfterDeletes);
        Assert.assertEquals(numberOfGroupsAfterSaves - 2L, numberOfGroupsAfterDeletes);
        Assert.assertFalse(groupRepository.findAll().contains(group1));
        Assert.assertFalse(groupRepository.findAll().contains(group1));
    }
}
