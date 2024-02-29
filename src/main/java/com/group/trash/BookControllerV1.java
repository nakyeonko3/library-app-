package com.group.trash;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerV1 {

    private final BookServiceV1 bookService;

    public BookControllerV1(BookServiceV1 bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public void saveBook(BookCreatePriceRequest bookCreateRequest){
        bookService.saveBook(bookCreateRequest.getName(), bookCreateRequest.getPrice());
    }
}
