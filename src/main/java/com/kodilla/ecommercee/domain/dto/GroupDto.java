package com.kodilla.ecommercee.domain.dto;

public class GroupDto {
    private long id;
    private String name;

    public GroupDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroupDto() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
