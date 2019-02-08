package com.kodilla.ecommercee.domain.dto;

public class UserDto {
    private Long id;
    private String username;
    private String status;
    private Long userKey;

    public UserDto() {
    }

    public UserDto(Long id, String username, String status, Long userKey) {
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
}
