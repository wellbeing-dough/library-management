package com.librarymanagement.book.repository;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.librarymanagement.config.RepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@RepositoryTest
@Disabled
class BookQueryDslRepositoryImplTest {

//    @Autowired
//    private BookRepository bookRepository;
//
//    @BeforeEach
//    void setUp() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book(null, "해리포터", "J.K. 롤링", "문학동네", LoanStatus.AVAILABLE, null, LocalDateTime.of(2001, 6, 26, 0, 0), 10L));
//        books.add(new Book(null, "반지의 제왕", "J.R.R. 톨킨", "민음사", LoanStatus.BORROWED, null, LocalDateTime.of(2002, 7, 29, 0, 0), 20L));
//        books.add(new Book(null, "데미안", "헤르만 헤세", "열린책들", LoanStatus.AVAILABLE, null, LocalDateTime.of(2005, 2, 1, 0, 0), 30L));
//        books.add(new Book(null, "1984", "조지 오웰", "한빛미디어", LoanStatus.BORROWED, null, LocalDateTime.of(2008, 6, 8, 0, 0), 40L));
//        books.add(new Book(null, "모비딕", "허먼 멜빌", "범우사", LoanStatus.AVAILABLE, null, LocalDateTime.of(2010, 10, 18, 0, 0), 50L));
//        books.add(new Book(null, "노인과 바다", "어니스트 헤밍웨이", "문예출판사", LoanStatus.BORROWED, null, LocalDateTime.of(2001, 9, 1, 0, 0), 60L));
//        books.add(new Book(null, "죄와 벌", "표도르 도스토옙스키", "민음사", LoanStatus.AVAILABLE, null, LocalDateTime.of(2003, 1, 1, 0, 0), 70L));
//        books.add(new Book(null, "백년의 고독", "가브리엘 가르시아 마르케스", "문학동네", LoanStatus.BORROWED, null, LocalDateTime.of(2006, 5, 30, 0, 0), 80L));
//        books.add(new Book(null, "오만과 편견", "제인 오스틴", "펭귄클래식", LoanStatus.AVAILABLE, null, LocalDateTime.of(2012, 1, 28, 0, 0), 90L));
//        books.add(new Book(null, "파울로의 여행", "파울로 코엘료", "열린책들", LoanStatus.BORROWED, null, LocalDateTime.of(2009, 5, 12, 0, 0), 100L));
//        bookRepository.saveAll(books);
//    }
//
//
//    @Test
//    void tag_id는_제외하고_저자를_기반으로_검색() {
//// given
//        String author = "파울로";
//
//        // when
//        List<GetBookHttpResponse> books = bookRepository.findListByAuthor(author, null, PageRequest.of(0, 5), SortByType.TITLE);
//
//        // then
//        assertThat(books).isNotEmpty();  // 결과가 비어있지 않은지 확인
//        assertThat(books).allSatisfy(book -> assertThat(book.getAuthor()).contains(author));
//    }

}