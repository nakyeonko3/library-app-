package com.group.libraryapp.controller;

import com.group.libraryapp.dto.user.request.book.BookCreateRequest;
import com.group.libraryapp.dto.user.request.book.BookGetResponse;
import com.group.libraryapp.dto.user.request.book.BookLoanRequest;
import com.group.libraryapp.dto.user.request.book.BookReturnRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookServiceV2) {
        this.bookService = bookServiceV2;
    }

    @PostMapping()
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
    }

    @GetMapping("/list")
    public List<BookGetResponse> getBooks(){
        return bookService.getBooks();
    }


    @PostMapping("/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

    @PutMapping("/return")
    public void returnBook(@RequestBody BookReturnRequest request){
        bookService.returnBook(request);
    }


}
