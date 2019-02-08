package com.kodilla.ecommercee.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    private Long id;
    private String username;
    private String status;
    private Long userKey;
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String username, String status, Long userKey) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    @Id
    @NotNull
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    @NotNull
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    @Column(name = "USERKEY")
    public Long getUserKey() {
        return userKey;
    }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}