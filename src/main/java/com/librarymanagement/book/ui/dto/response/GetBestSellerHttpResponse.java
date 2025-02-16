package com.librarymanagement.book.ui.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetBestSellerHttpResponse {

    private List<GetBookHttpResponse> bestSellerBooks;

    // 기존 생성자 유지
    public GetBestSellerHttpResponse(List<GetBookHttpResponse> bestSellerBooks) {
        this.bestSellerBooks = bestSellerBooks;
    }

}
