package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class BookLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String bookName;
    private boolean isReturn = true;
    protected BookLoanHistory() {
    }
    public BookLoanHistory(Long userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isReturn() {
        return isReturn;
    }
}
