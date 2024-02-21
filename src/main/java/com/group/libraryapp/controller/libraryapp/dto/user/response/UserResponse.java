package com.group.libraryapp.controller.libraryapp.dto.user.response;

import com.group.libraryapp.controller.libraryapp.domain.User;

public class UserResponse {
    final private long id;
    final private String name;
    final private Integer age;

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

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
