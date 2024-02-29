package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.User;


public class UserResponse {
    private final long id;
    private final String name;
    private final Integer age;

    public UserResponse(Integer id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public UserResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.age = user.getAge();
        this.name = user.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
