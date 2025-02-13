package com.librarymanagement.loan.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long bookId;

    private Integer penalty;

    private LocalDateTime dueDate;

    private LocalDateTime returnDate;

    public void updateWhenReturn(Integer delayPenalty) {
        this.returnDate = LocalDateTime.now();
        this.penalty = delayPenalty;
    }
}
