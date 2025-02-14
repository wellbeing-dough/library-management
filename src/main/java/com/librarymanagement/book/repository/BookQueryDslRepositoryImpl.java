package com.librarymanagement.book.repository;

import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.librarymanagement.book.domain.entity.QBook.book;

@Repository
@RequiredArgsConstructor
public class BookQueryDslRepositoryImpl implements BookQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<GetBookHttpResponse> findListByAuthor(String author, Pageable pageable, SortByType sortBy) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        GetBookHttpResponse.class,
                        book.id.as("bookId"),
                        book.title,
                        book.author,
                        book.loanStatus
                ))
                .from(book)
                .where(book.author.like("%" + author + "%"))
                .orderBy(sortPredicate(sortBy), book.id.asc())
                .offset(pageable.getOffset())  // 페이징 처리
                .limit(pageable.getPageSize() + 1)  // 페이징 처리
                .fetch();
    }

    @Override
    public List<GetBookHttpResponse> findListByTitle(String title, Pageable pageable, SortByType sortBy) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        GetBookHttpResponse.class,
                        book.id.as("bookId"),
                        book.title,
                        book.author,
                        book.loanStatus
                ))
                .from(book)
                .where(book.title.like("%" + title + "%"))
                .orderBy(sortPredicate(sortBy), book.id.asc())
                .offset(pageable.getOffset())  // 페이징 처리
                .limit(pageable.getPageSize() + 1)  // 페이징 처리
                .fetch();
    }

    private OrderSpecifier<?> sortPredicate(SortByType sortByType) {
        if (sortByType == SortByType.TITLE) {
            return book.title.asc();
        }
        if (sortByType == SortByType.PUBLISHED_AT) {
            return book.publishedAt.asc();
        }
        return null;
    }
}
