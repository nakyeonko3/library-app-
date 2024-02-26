package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    List<Book> books = new ArrayList<Book>();
    public void saveBook(String name, Integer price){

        books.add(new Book(name, price));
        System.out.println(books.stream().map(book -> book.getName() + ":" + book.getPrice() +", ").collect(Collectors.joining()));
    }
}
