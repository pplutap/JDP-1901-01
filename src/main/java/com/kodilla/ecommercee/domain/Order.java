package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    private User user;
    private List<Product> productList;

    private Order() {}

    public Order(long id, List<Product> productList, User user) {
        this.id = id;
        this.productList = productList;
        this.user = user;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @Column(name = "Products")
    public List<Product> getProductList() {
        return productList;
    }

}