package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GROUPS")
public class Group {
    private long id;
    private String name;
    private Set<Product> productsInGroup = new HashSet<>();

    public Group(long id, String name, Set<Product> productsInGroup) {
        this.id = id;
        this.name = name;
        this.productsInGroup = productsInGroup;
    }

    public Group() {}

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
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
            mappedBy = "productsInGroup",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public Set<Product> getProductsInGroup() {
        return productsInGroup;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setProductsInGroup(Set<Product> productsInGroup) {
        this.productsInGroup = productsInGroup;
    }
}
