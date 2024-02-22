package com.group.libraryapp.dto.user.request;

public class UserUpdateRequest {
    private final Integer id;
    private final String name;

    public UserUpdateRequest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
