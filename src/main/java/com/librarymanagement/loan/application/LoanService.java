package com.librarymanagement.loan.application;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.domain.implementations.BookReader;
import com.librarymanagement.loan.domain.implementations.LoanTimeGenerator;
import com.librarymanagement.loan.domain.implementations.LoanValidator;
import com.librarymanagement.loan.domain.implementations.LoanWriter;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.domian.implementations.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final UserReader userReader;
    private final LoanWriter loanWriter;
    private final BookReader bookReader;
    private final LoanTimeGenerator loanTimeGenerator;
    private final LoanValidator loanValidator;

    public void borrowBook(Long bookId, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookReader.readById(bookId);
        loanValidator.isPossibleToBorrow(book.getId());
        LocalDateTime dueDate = loanTimeGenerator.generateDueDate(LocalDateTime.now());
        loanWriter.createLoan(book.getId(), user.getId(), dueDate);
    }
}
