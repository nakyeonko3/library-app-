package com.group.libraryapp.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserLoanHistory> userLoanHistories;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false, length = 20)
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

    public void updateName(String name) {
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

    public void removeOneHistory(String bookName) {
        this.userLoanHistories.removeIf(userLoanHistory -> bookName.equals(userLoanHistory.getBookName()));
    }

    public void loanBook(String bookName) {
        this.userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName()
                        .equals(bookName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();
    }
}
