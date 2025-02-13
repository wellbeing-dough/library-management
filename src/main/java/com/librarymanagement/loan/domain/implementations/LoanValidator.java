package com.librarymanagement.loan.domain.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.loan.domain.entity.Loan;
import com.librarymanagement.loan.exception.AlreadyBorrowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoanValidator {

    private final LoanReader loanReader;

    public void isPossibleToBorrow(Long bookId) {
        Optional<Loan> optionalLoan = loanReader.readOptionalByNonReturn(bookId);
        optionalLoan.ifPresent(loan -> {
            throw new AlreadyBorrowedException(
                    ErrorCode.ALREADY_BORROWED_ERROR,
                    ErrorCode.ALREADY_BORROWED_ERROR.getStatusMessage()
            );
        });
    }



}
