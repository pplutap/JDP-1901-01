package com.kodilla.ecommercee;

    public class User {
    private Long id;
    private String username;
    private String status;
    private Long userKey;

    public User() {
    }

    public User(Long id, String username, String status, Long userKey) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
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
}
