package com.librarymanagement.loan.domain.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.loan.domain.entity.Loan;
import com.librarymanagement.loan.exception.LoanNotFoundException;
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

    public Optional<Loan> readNonReturnOptionalByBookId(Long bookId) {
        return loanRepository.findNonReturnOptionalByBookId(bookId);
    }

    public Loan readByBookIdAndUserId(Long bookId) {
        return loanRepository.findByBookId(bookId)
                .orElseThrow(() ->
                        new LoanNotFoundException(
                                ErrorCode.LOAN_NOT_FOUND_ERROR,
                                ErrorCode.LOAN_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }
}
