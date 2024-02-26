package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
public class BookMermoryRepository implements BookRepository{
    List<Book> books = new ArrayList<Book>();
    @Override
    public void saveBook(String name, Long price) {
        books.add(new Book(name, price));
        System.out.println(books.stream().map(book -> book.getName()+", ").collect(Collectors.joining()));
    }
}
