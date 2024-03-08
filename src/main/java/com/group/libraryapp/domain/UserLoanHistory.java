package com.group.libraryapp.domain;

import lombok.Getter;

import jakarta.persistence.*;

@Getter
@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final private Long id = null;

    @ManyToOne()
    User user;
    private String bookName;
    private boolean isReturn;
    protected UserLoanHistory() {
    }
    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
        this.isReturn = true;
    }

    public boolean isReturn() {
        return isReturn;
    }
}
