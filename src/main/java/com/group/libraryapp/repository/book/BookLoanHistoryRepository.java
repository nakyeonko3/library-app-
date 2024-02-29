package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.BookLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanHistoryRepository extends JpaRepository<BookLoanHistory,Long> {
}
