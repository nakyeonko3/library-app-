package com.group.libraryapp.dto.user.request.book;

import com.sun.istack.NotNull;

public class BookLoanRequest {
    @NotNull
    private String userName;

    @NotNull
    private String bookName;

    public BookLoanRequest() {
    }

    public BookLoanRequest(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
