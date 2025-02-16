package com.librarymanagement.loan.domain.implementations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class LoanPenaltyGeneratorTest {

    private LoanPenaltyGenerator penaltyGenerator;

    @BeforeEach
    void setUp() {
        penaltyGenerator = new LoanPenaltyGenerator();
    }

    @Test
    void testGeneratePenalty_NoPenalty() {
        // Given: 반납일이 마감일 이전 또는 동일한 경우
        LocalDateTime dueDate = LocalDateTime.of(2025, 2, 10, 12, 0);
        LocalDateTime returnDate = LocalDateTime.of(2025, 2, 10, 12, 0);

        // When: generateDeplayPenalty 호출
        int penalty = penaltyGenerator.generateDelayPenalty(dueDate, returnDate);

        // Then: 벌금은 0이어야 한다
        assertEquals(0, penalty);
    }

    @Test
    void testGeneratePenalty_WithPenalty() {
        // Given: 반납일이 마감일 이후인 경우
        LocalDateTime dueDate = LocalDateTime.of(2025, 2, 10, 12, 0);
        LocalDateTime returnDate = LocalDateTime.of(2025, 2, 12, 12, 0);  // 2일 지연

        // When: generateDeplayPenalty 호출
        int penalty = penaltyGenerator.generateDelayPenalty(dueDate, returnDate);

        // Then: 2일 지연에 대해 2000원의 벌금이 부과된다
        assertEquals(2000, penalty);
    }

    @Test
    void testGeneratePenalty_WithLargePenalty() {
        // Given: 반납일이 마감일 이후로 며칠 지연된 경우
        LocalDateTime dueDate = LocalDateTime.of(2025, 2, 10, 12, 0);
        LocalDateTime returnDate = LocalDateTime.of(2025, 2, 15, 12, 0);  // 5일 지연

        // When: generateDeplayPenalty 호출
        int penalty = penaltyGenerator.generateDelayPenalty(dueDate, returnDate);

        // Then: 5일 지연에 대해 5000원의 벌금이 부과된다
        assertEquals(5000, penalty);
    }

    @Test
    void testGeneratePenalty_ZeroPenaltyIfNoDelay() {
        // Given: 반납일이 마감일 이전인 경우
        LocalDateTime dueDate = LocalDateTime.of(2025, 2, 10, 12, 0);
        LocalDateTime returnDate = LocalDateTime.of(2025, 2, 9, 12, 0);  // 1일 이전

        // When: generateDeplayPenalty 호출
        int penalty = penaltyGenerator.generateDelayPenalty(dueDate, returnDate);

        // Then: 벌금은 0이어야 한다
        assertEquals(0, penalty);
    }
}
