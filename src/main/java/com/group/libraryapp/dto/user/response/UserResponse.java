package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.User;

public class UserResponse {
    final private Integer id;
    final private String name;
    final private Integer age;

    public UserResponse(Integer id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
