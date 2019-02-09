package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private String status;
    private Long userKey;
    private List<Order> orders = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long id, String username, String status, Long userKey, List<Order> orders) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserKey() {
        return userKey;
    }

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
