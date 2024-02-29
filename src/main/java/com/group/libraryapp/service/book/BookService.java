package com.group.libraryapp.service.book;

import com.group.libraryapp.dto.user.request.book.BookCreateRequest;
import com.group.libraryapp.dto.user.request.book.BookLoanRequest;

public interface BookService {
    void saveBook(BookCreateRequest request);
    void loanBook(BookLoanRequest request);
}
