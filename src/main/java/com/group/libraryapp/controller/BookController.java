package com.group.libraryapp.controller;

import com.group.libraryapp.dto.user.request.book.BookCreateRequest;
import com.group.libraryapp.dto.user.request.book.BookLoanRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookServiceV2;

    public BookController(BookService bookServiceV2) {
        this.bookServiceV2 = bookServiceV2;
    }

    @PostMapping()
    public void saveBook(@RequestBody BookCreateRequest request){
        bookServiceV2.saveBook(request);
    }

    @PostMapping("/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookServiceV2.loanBook(request);
    }

}
