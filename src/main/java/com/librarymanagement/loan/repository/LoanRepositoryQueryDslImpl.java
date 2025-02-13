package com.librarymanagement.loan.repository;

import com.librarymanagement.loan.domain.entity.Loan;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.librarymanagement.loan.domain.entity.QLoan.loan;

@Repository
@RequiredArgsConstructor
public class LoanRepositoryQueryDslImpl implements LoanRepositoryQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Loan> findOptionalByNonReturn(Long bookId) {

        Loan queryData = jpaQueryFactory
                .selectFrom(loan)
                .where(
                        loan.bookId.eq(bookId)
                                .and(loan.returnDate.isNull())
                )
                .fetchFirst();
        return Optional.ofNullable(queryData);
    }
}
