package com.group.libraryapp.controller;

import com.group.libraryapp.dto.user.request.BookCreateRequest;
import com.group.libraryapp.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public void saveBook(BookCreateRequest bookCreateRequest){
        bookService.saveBook(bookCreateRequest.getName(), bookCreateRequest.getPrice());
    }
}
