package com.group.libraryapp.controller;

import com.group.libraryapp.dto.BookCreateRequest;
import com.group.libraryapp.dto.BookResponse;
import com.group.libraryapp.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    final BookService bookService = new BookService();
    @GetMapping("/book")
    public void saveBook(BookCreateRequest bookCreateRequest){
        bookService.saveBook(bookCreateRequest.getName(), bookCreateRequest.getPrice());
    }
}
