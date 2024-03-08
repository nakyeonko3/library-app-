package com.group.libraryapp.dto.user.request.book;




public class BookLoanRequest {

    private String userName;

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
