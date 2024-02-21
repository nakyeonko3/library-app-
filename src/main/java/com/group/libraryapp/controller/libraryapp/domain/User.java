package com.group.libraryapp.controller.libraryapp.domain;

public class User {
    final private Integer age;
    final private String name;

    public User(Integer age, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어 왔습니다."));
        }
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
