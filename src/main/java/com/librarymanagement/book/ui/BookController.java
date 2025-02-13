package com.librarymanagement.book.ui;

import com.librarymanagement.book.application.BookService;
import com.librarymanagement.book.ui.dto.request.CreateBookHttpRequest;
import com.librarymanagement.book.ui.dto.request.updateBookHttpRequest;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.interceptor.annotation.Authenticated;
import com.librarymanagement.common.resolver.annotation.UserIdentifier;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "도서 등록")
    @PostMapping("/v1/books")
    @Authenticated
    public ResponseEntity<HttpStatus> createBook(@Valid @RequestBody CreateBookHttpRequest request,
                                                 @UserIdentifier Long userId) {
        Long bookId = bookService.createBook(request.getTitle(), request.getAuthor(), request.getPublisher(), userId);
        return ResponseEntity.created(URI.create("/v1/books/" + bookId)).build();
    }

    @Operation(summary = "도서 단건 조회")
    @GetMapping("/v1/books/{book-id}")
    public ResponseEntity<GetBookHttpResponse> getBookInfo(@PathVariable("book-id") Long bookId) {
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

}
