package com.librarymanagement.tag.ui.dto.response;

import lombok.Getter;

@Getter
public class GetTagHttpResponse {
    private final Long id;
    private final String name;

    public GetTagHttpResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
