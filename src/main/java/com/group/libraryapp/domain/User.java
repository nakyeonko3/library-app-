package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String name;
    private Integer age;


    public User(Integer age, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("잘못된 name(%s)이 들어 왔습니다.");
        }
        this.age = age;
        this.name = name;
    }

    protected User() {
    }

    public void updateName(String name){
        this.name = name;
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
