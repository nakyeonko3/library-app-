package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserLoanHistory;
import com.group.libraryapp.dto.user.request.book.BookCreateRequest;
import com.group.libraryapp.dto.user.request.book.BookGetResponse;
import com.group.libraryapp.dto.user.request.book.BookLoanRequest;
import com.group.libraryapp.dto.user.request.book.BookReturnRequest;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.book.UserLoanHistoryRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    private final UserRepository userRepository;

    public BookService(BookRepository bookJpaRepository, UserLoanHistoryRepository bookLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookJpaRepository;
        this.userLoanHistoryRepository = bookLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }


    @Transactional
    public void loanBook(BookLoanRequest request) {

        // 1. 책 정보를 가져온다.
        bookRepository.findByName(request.getBookName())
                .orElseThrow(() -> new ArithmeticException(String.format("can't find %s", request.getBookName())));

        // 2. 책 대출 정보를 확인한다.
        boolean isReturn = userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false);

        // 3. 만약 대출 중이라면 예외를 발생시킨다.
        if (isReturn) {
            throw new IllegalArgumentException(String.format("대출된 도서입니다,%s", request.getBookName()));
        }

        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(() -> new ArithmeticException(String.format("can't find %s", request.getUserName())));

        // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory를 저장한다.
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), request.getBookName()));
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {

        // 2. 유저 이름으로 유저 아이디를 찾아 낸다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. UserLoanHistory에서 책 정보를 가져온다.
        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByBookNameAndIsReturn(request.getBookName(), false)
                .orElseThrow(IllegalArgumentException::new);

        // 3. 가져온 책 정보를 반납으로 업데이트한다.
        userLoanHistory.doReturn();
    }


    @Transactional
    public List<BookGetResponse> getBooks() {

        return bookRepository.findAll()
                .stream()
                .map(book -> new BookGetResponse(book.getId(), book.getName()))
                .collect(Collectors.toList());
    }

}
