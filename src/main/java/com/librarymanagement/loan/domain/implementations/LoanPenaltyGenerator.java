package com.librarymanagement.loan.domain.implementations;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class LoanPenaltyGenerator {

    private static final int PENALTY_PER_DAY = 1000;

    public Integer generateDelayPenalty(LocalDateTime dueDate, LocalDateTime returnDate) {
        // 제한 기간을 넘지 않았다면 벌금 없음
        if (returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {
            return 0;
        }

        // 제한 기간을 넘겼다면, 하루씩 추가된 벌금을 계산
        long daysLate = Duration.between(dueDate, returnDate).toDays();

        // 하루에 1000원씩 벌금 계산
        return (int) (daysLate * PENALTY_PER_DAY);
    }
}
