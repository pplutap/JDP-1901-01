package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS_GROUPS")
public class Group {
    private long id;
    private String name;
    private Set<Product> products = new HashSet<>();

    public Group(long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Group() {}

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID")
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "GROUP_NAME", unique = true)
    public String getName() {
        return name;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public Set<Product> getProducts() {
        return products;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setProducts(Set<Product> products) {
        this.products = products;
    }
}
