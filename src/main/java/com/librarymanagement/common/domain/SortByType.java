package com.librarymanagement.common.domain;

public enum SortByType {
    TITLE("제목"),
    CREATED_AT("")
    ;


    SortByType(String value) {
        this.value = value;
    }

    private final String value;
}
