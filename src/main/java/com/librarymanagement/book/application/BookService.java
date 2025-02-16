package com.librarymanagement.book.application;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.domain.implementations.BookReader;
import com.librarymanagement.book.domain.implementations.BookValidator;
import com.librarymanagement.book.domain.implementations.BookWriter;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.book.ui.dto.response.GetBookInfoHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.librarymanagement.common.dto.Converter;
import com.librarymanagement.tag.domain.entity.Tag;
import com.librarymanagement.tag.domain.implementations.BookTagValidator;
import com.librarymanagement.tag.domain.implementations.BookTagWriter;
import com.librarymanagement.tag.domain.implementations.TagReader;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.domian.implementations.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookWriter bookWriter;
    private final UserReader userReader;
    private final BookReader bookReader;
    private final BookValidator bookValidator;
    private final TagReader tagReader;
    private final BookTagValidator bookTagValidator;
    private final BookTagWriter bookTagWriter;

    public Long createBook(String title, String author, String publisher, LocalDateTime publishedAt, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookWriter.createBook(title, author, publisher, publishedAt);
        return book.getId();
    }

    @Cacheable(value = "book", key = "#bookId", cacheManager = "bookInfoCacheManager")
    public GetBookInfoHttpResponse getBookInfo(Long bookId) {
        Book book = bookReader.readById(bookId);
        return new GetBookInfoHttpResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(),
                book.getLoanStatus().getValue(), book.getLoanCount(), book.getPublishedAt());
    }

    @CacheEvict(value = "book", key = "#bookId", cacheManager = "bookInfoCacheManager")
    public void updateBook(Long bookId, String title, String author, String publisher, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookReader.readById(bookId);
        book.updateInfo(title, author, publisher);
        bookWriter.write(book);
    }

    @CacheEvict(value = "book", key = "#bookId", cacheManager = "bookInfoCacheManager")
    public void deleteBook(Long bookId, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookReader.readById(bookId);
        bookValidator.isPossibleToDelete(book);
        book.mockDelete(LocalDateTime.now());
        bookWriter.write(book);
    }

    public Slice<GetBookHttpResponse> searchBooksByAuthor(String author, Long tagId, int page, int size, SortByType sortBy) {
        final Pageable pageable = PageRequest.of(page, size);
        return Converter.toSlice(pageable, bookReader.readListByAuthor(author, tagId, pageable, sortBy));
    }

    public Slice<GetBookHttpResponse> searchBooksByTitle(String title, Long tagId, int page, int size, SortByType sortBy) {
        final Pageable pageable = PageRequest.of(page, size);
        return Converter.toSlice(pageable, bookReader.readListByTitle(title, tagId, pageable, sortBy));
    }

    public void addTagBook(Long tagId, Long bookId) {
        Tag tag = tagReader.readById(tagId);
        Book book = bookReader.readById(bookId);
        bookTagValidator.isAlreadyExistsBookTag(tag, book);
        bookTagWriter.writeBookTag(tag, book);
    }

    public List<GetBookHttpResponse> getBestSeller() {

    }
}
