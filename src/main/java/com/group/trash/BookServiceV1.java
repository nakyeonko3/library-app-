package com.group.trash;

import org.springframework.stereotype.Service;

@Service
public class BookServiceV1{
    BookJdbcRepositoryimpl bookRepository;

    public BookServiceV1(BookJdbcRepositoryimpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(String name, Long price){
        // TODO: 특수 문자열(!,$,%,')에 대한 유효성 검사가 필요함.
        this.checkNameAndPrice(name, price);
        bookRepository.saveBook(name, price);
    }

    public void checkNameAndPrice(String name, Long price){
        if(name.isEmpty() && price != null) {
            throw new IllegalArgumentException();
        }
    }
}

