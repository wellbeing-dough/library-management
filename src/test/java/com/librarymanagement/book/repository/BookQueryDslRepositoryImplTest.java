package com.librarymanagement.book.repository;

import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.librarymanagement.config.RepositoryTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
class BookQueryDslRepositoryImplTest {

    @Autowired
    private BookQueryDslRepositoryImpl bookRepository;

    @Test
    void tag_id는_제외하고_저자를_기반으로_검색() {
// given
        String author = "파울로";

        // when
        List<GetBookHttpResponse> books = bookRepository.findListByAuthor(author, null, PageRequest.of(0, 5), SortByType.TITLE);

        // then
        assertThat(books).isNotEmpty();  // 결과가 비어있지 않은지 확인
        assertThat(books).allSatisfy(book -> assertThat(book.getAuthor()).contains(author));
    }

}