package com.librarymanagement.book.repository;

import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookQueryDslRepository {
    List<GetBookHttpResponse> findListByAuthor(String author, Long tagId, Pageable pageable, SortByType sortBy);

    List<GetBookHttpResponse> findListByTitle(String title, Long tagId, Pageable pageable, SortByType sortBy);

    List<GetBookHttpResponse> getBestSeller();
}
