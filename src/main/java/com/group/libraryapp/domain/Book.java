package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    public Book(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("잘못된 name(%s)이 들어 왔습니다.");
        }
        this.name = name;
    }

    protected Book(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
