package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);
}
