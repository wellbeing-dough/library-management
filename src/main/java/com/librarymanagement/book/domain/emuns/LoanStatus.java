package com.librarymanagement.book.domain.emuns;

import lombok.Getter;

@Getter
public enum LoanStatus {
    AVAILABLE("대출 가능"),
    BORROWED("대출 중"),
    ;

    private final String value;

    LoanStatus(String value) {
        this.value = value;
    }
}
