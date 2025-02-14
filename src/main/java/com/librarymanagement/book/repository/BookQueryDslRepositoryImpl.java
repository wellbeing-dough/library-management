package com.librarymanagement.book.repository;

import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.librarymanagement.book.domain.entity.QBook.book;
import static com.librarymanagement.tag.domain.entity.QBookTag.bookTag;

@Repository
@RequiredArgsConstructor
public class BookQueryDslRepositoryImpl implements BookQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<GetBookHttpResponse> findListByAuthor(String author, Long tagId, Pageable pageable, SortByType sortBy) {
        JPAQuery<GetBookHttpResponse> query = jpaQueryFactory
                .select(Projections.constructor(
                        GetBookHttpResponse.class,
                        book.id.as("bookId"),
                        book.title,
                        book.author,
                        book.loanStatus
                ))
                .from(book);

        // author가 null이 아니고 빈 문자열이 아닐 경우만 검색 조건 추가
        if (author != null && !author.isBlank()) {
            query.where(book.author.like("%" + author + "%"));
        }

        // tagId가 존재하면 book_tag 테이블을 조인하여 태그 필터링 적용
        if (tagId != null) {
            query.join(bookTag).on(book.id.eq(bookTag.bookId))
                    .where(bookTag.tagId.eq(tagId));
        }

        return query.orderBy(sortPredicate(sortBy), book.id.asc())
                .offset(pageable.getOffset())  // 페이징 처리
                .limit(pageable.getPageSize() + 1)  // 페이징 처리
                .fetch();
    }


    @Override
    public List<GetBookHttpResponse> findListByTitle(String title, Long tagId, Pageable pageable, SortByType sortBy) {
        JPAQuery<GetBookHttpResponse> query = jpaQueryFactory
                .select(Projections.constructor(
                        GetBookHttpResponse.class,
                        book.id.as("bookId"),
                        book.title,
                        book.author,
                        book.loanStatus
                ))
                .from(book);

        if (title != null && !title.isBlank()) {
            query.where(book.title.like("%" + title + "%"));
        }

        // tagId가 존재하면 book_tag 테이블을 조인하여 태그 필터링 적용
        if (tagId != null) {
            query.join(bookTag).on(book.id.eq(bookTag.bookId))
                    .where(bookTag.tagId.eq(tagId));
        }

        return query.orderBy(sortPredicate(sortBy), book.id.asc())
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
