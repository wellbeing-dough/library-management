package com.librarymanagement.loan.domain.implementations;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LoanTimeGenerator {

    private static final int LOAN_PERIOD_WEEKS = 1;
    private static final int DUE_HOUR = 23;
    private static final int DUE_MINUTE = 59;
    private static final int DUE_SECOND = 0;
    private static final int DUE_NANOSECOND = 0;

    public LocalDateTime generateDueDate(LocalDateTime dueDate) {
        return LocalDateTime.now()
                .plusWeeks(LOAN_PERIOD_WEEKS)
                .withHour(DUE_HOUR)
                .withMinute(DUE_MINUTE)
                .withSecond(DUE_SECOND)
                .withNano(DUE_NANOSECOND);
    }
}
