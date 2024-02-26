package com.group.libraryapp.service;

import com.group.libraryapp.repository.book.BookMySqlRepository;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(String name, Long price){
        // TODO: 특수 문자열(!,$,%,')에 대한 유효성 검사가 필요함.
        if(name.isEmpty() && price != null) {
            throw new IllegalArgumentException();
        }

        bookRepository.saveBook(name, price);
    }
}

