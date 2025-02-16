package com.librarymanagement.book.ui;

import com.librarymanagement.book.application.BookService;
import com.librarymanagement.book.ui.dto.request.AddTagToBookHttpRequest;
import com.librarymanagement.book.ui.dto.request.CreateBookHttpRequest;
import com.librarymanagement.book.ui.dto.request.updateBookHttpRequest;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.book.ui.dto.response.GetBookInfoHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.librarymanagement.common.interceptor.annotation.Authenticated;
import com.librarymanagement.common.resolver.annotation.UserIdentifier;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "도서 등록")
    @PostMapping("/v1/books")
    @Authenticated
    public ResponseEntity<HttpStatus> createBook(@Valid @RequestBody CreateBookHttpRequest request,
                                                 @UserIdentifier Long userId) {
        Long bookId = bookService.createBook(request.getTitle(), request.getAuthor(), request.getPublisher(),
                request.getPublishedAt(), userId);
        return ResponseEntity.created(URI.create("/v1/books/" + bookId)).build();
    }

    @Operation(summary = "도서 단건 조회")
    @GetMapping("/v1/books/{book-id}")
    public ResponseEntity<GetBookInfoHttpResponse> getBookInfo(@PathVariable("book-id") Long bookId) {
        return ResponseEntity.ok().body(bookService.getBookInfo(bookId));
    }

    @Operation(summary = "도서 수정")
    @PutMapping("/v1/books")
    @Authenticated
    public ResponseEntity<HttpStatus> updateBook(@Valid @RequestBody updateBookHttpRequest request,
                                                 @UserIdentifier Long userId) {
        bookService.updateBook(request.getBookId(), request.getTitle(), request.getAuthor(), request.getPublisher(), userId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "도서 삭제")
    @DeleteMapping("/v1/books/{book-id}")
    @Authenticated
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("book-id") Long bookId,
                                                 @UserIdentifier Long userId) {
        bookService.deleteBook(bookId, userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "저자명으로 도서 검색")
    @GetMapping("/v1/books/author")
    public ResponseEntity<Slice<GetBookHttpResponse>> searchBooksByAuthor(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "tag-id", required = false) Long tagId,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sort-by")SortByType sortBy
    ) {
        return ResponseEntity.ok().body(bookService.searchBooksByAuthor(author, tagId, page, size, sortBy));
    }

    @Operation(summary = "제목으로 도서 검색")
    @GetMapping("/v1/books/title")
    public ResponseEntity<Slice<GetBookHttpResponse>> searchBooksByTitle(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "tag-id", required = false) Long tagId,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sort-by")SortByType sortBy
    ) {
        return ResponseEntity.ok().body(bookService.searchBooksByTitle(title, tagId, page, size, sortBy));
    }

    @Operation(summary = "도서에 태그 추가")
    @PostMapping("/v1/books/tag")
    public ResponseEntity<HttpStatus> addTagToBook(@Valid @RequestBody AddTagToBookHttpRequest request) {
        bookService.addTagBook(request.getTagId(), request.getBookId());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "베스트 셀러")
    @GetMapping("/v1/books/best-seller")
    public ResponseEntity<List<GetBookHttpResponse>> getBestSeller() {
        return ResponseEntity.ok().body(bookService.getBestSeller());
    }

}
