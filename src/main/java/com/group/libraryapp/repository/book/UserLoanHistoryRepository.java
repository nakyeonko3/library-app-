package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory,Long> {
//
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

    Optional<UserLoanHistory> findByBookNameAndIsReturn(String bookName, boolean isReturn);

    List<UserLoanHistoryView> findAllByUserId(long userId);
}
