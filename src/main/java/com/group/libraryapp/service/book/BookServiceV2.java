package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.BookLoanHistory;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.book.BookCreateRequest;
import com.group.libraryapp.dto.user.request.book.BookLoanRequest;
import com.group.libraryapp.repository.book.BookLoanHistoryRepository;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Service
public class BookServiceV2 implements BookService {
    private final BookRepository bookJpaRepository;
    private final BookLoanHistoryRepository bookLoanHistoryRepository;

    private final UserRepository userRepository;

    public BookServiceV2(BookRepository bookJpaRepository, BookLoanHistoryRepository bookLoanHistoryRepository, UserRepository userRepository) {
        this.bookJpaRepository = bookJpaRepository;
        this.bookLoanHistoryRepository = bookLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookJpaRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
//        System.out.println(request.getBookName() + request.getUserName());
        bookJpaRepository.findByName(request.getBookName())
                .orElseThrow(()->new ArithmeticException(String.format("can't find %s",request.getBookName())));

        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(()->new ArithmeticException(String.format("can't find %s",request.getUserName())));

//        System.out.println(book.getId());
        bookLoanHistoryRepository.save(new BookLoanHistory(user.getId(), request.getBookName()));
    }

//    public void validate(String name){
//        if (name == null || name.isBlank()) {
//            throw new IllegalArgumentException("잘못된 name(%s)이 들어 왔습니다.");
//        }
//    }
}
