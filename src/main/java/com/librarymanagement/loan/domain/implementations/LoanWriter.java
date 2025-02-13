package com.librarymanagement.loan.domain.implementations;

import com.librarymanagement.loan.domain.entity.Loan;
import com.librarymanagement.loan.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Transactional
public class LoanWriter {

    private final LoanRepository loanRepository;

    public void createLoan(Long bookId, Long userId, LocalDateTime dueDate) {
        Loan loan = createLoanEntity(bookId, userId, dueDate);
        loanRepository.save(loan);
    }

    private Loan createLoanEntity(Long bookId, Long userId, LocalDateTime dueDate) {
        return Loan.builder()
                .userId(userId)
                .bookId(bookId)
                .dueDate(dueDate)
                .build();
    }
}
