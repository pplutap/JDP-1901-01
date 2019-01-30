package com.kodilla.ecommercee.domain;

public class Group {
    private long id;
    private String name;

    public Group(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(Group group) {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
