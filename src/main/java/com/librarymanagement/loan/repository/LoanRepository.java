package com.librarymanagement.loan.repository;

import com.librarymanagement.loan.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long>, LoanRepositoryQueryDsl {
    Optional<Loan> findByBookId(Long bookId);
}
