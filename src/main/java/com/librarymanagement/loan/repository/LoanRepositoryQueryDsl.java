package com.librarymanagement.loan.repository;

import com.librarymanagement.loan.domain.entity.Loan;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepositoryQueryDsl {
    Optional<Loan> findNonReturnOptionalByBookId(Long bookId);

}
