package com.librarymanagement.common.domain;

public enum SortByType {
    TITLE("제목"),
    PUBLISHED_AT("출판일")
    ;


    SortByType(String value) {
        this.value = value;
    }

    private final String value;
}
