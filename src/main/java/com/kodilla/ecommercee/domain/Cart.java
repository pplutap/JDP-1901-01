package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CARTS")
public class Cart {
    private Long id;
    private List<Product> products = new ArrayList<>();

    public Cart() {}

    public Cart(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    public Long getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
