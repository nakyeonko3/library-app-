package com.group.libraryapp.controller.libraryapp.dto.user.request;

public class UserCreateRequest {
    final private String name;
    final private Integer age;

    public UserCreateRequest(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
