package com.librarymanagement.loan.domain.implementations;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.domain.implementations.BookWriter;
import com.librarymanagement.loan.domain.entity.Loan;
import com.librarymanagement.user.domian.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Transactional
public class BookLoanManager {

    private final BookWriter bookWriter;
    private final LoanWriter loanWriter;

    public void borrowBook(Book book, User user, LocalDateTime dueDate) {
        book.updateLoanStatus(LoanStatus.BORROWED);
        loanWriter.createLoan(book.getId(), user.getId(), dueDate);
        bookWriter.write(book);
    }

    public void returnBook(Book book, Loan loan, Integer delayPenalty) {
        book.updateLoanStatus(LoanStatus.AVAILABLE);
        loan.updateWhenReturn(delayPenalty);
        loanWriter.write(loan);
        bookWriter.write(book);
    }
}
