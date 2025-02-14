package com.librarymanagement.loan.domain.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTimeGeneratorTest {

    private LoanTimeGenerator loanTimeGenerator;

    @BeforeEach
    void setUp() {
        loanTimeGenerator = new LoanTimeGenerator();
    }

    @Test
    void generateDueDate_shouldReturnCorrectDueDate() {
        // Given
        LocalDateTime baseDate = LocalDateTime.of(2025, 2, 15, 10, 0, 0, 0);
        LocalDateTime expectedDueDate = LocalDateTime.of(2025, 2, 22, 23, 59, 0, 0);

        // When
        LocalDateTime dueDate = loanTimeGenerator.generateDueDate(baseDate);

        // Then
        assertEquals(expectedDueDate, dueDate);
    }
}