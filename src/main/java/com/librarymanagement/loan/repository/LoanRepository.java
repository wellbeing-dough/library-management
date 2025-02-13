package com.librarymanagement.loan.repository;

import com.librarymanagement.loan.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long>, LoanRepositoryQueryDsl {
}
