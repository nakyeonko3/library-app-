package com.group.libraryapp.service;

import antlr.StringUtils;
import com.group.libraryapp.repository.book.BookRepository;

public class BookService {
    BookRepository bookRepository = new BookRepository();
    public void saveBook(String name, Integer price){
        // TODO: 특수 문자열(!,$,%,')에 대한 유효성 검사가 필요함.
        if(name.isEmpty() && price != null) {
            throw new IllegalArgumentException();
        }

        bookRepository.saveBook(name, price);
    }
}

