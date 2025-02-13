package com.librarymanagement.loan.domain.implementations;

import com.librarymanagement.loan.domain.entity.Loan;
import com.librarymanagement.loan.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoanReader {

    private final LoanRepository loanRepository;

    public Optional<Loan> readOptionalByNonReturn(Long bookId) {
        return loanRepository.findOptionalByNonReturn(bookId);
    }
}
