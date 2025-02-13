package com.librarymanagement.loan.ui;

import com.librarymanagement.common.interceptor.annotation.Authenticated;
import com.librarymanagement.common.resolver.annotation.UserIdentifier;
import com.librarymanagement.loan.application.LoanService;
import com.librarymanagement.loan.ui.dto.request.BorrowBookHttpRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @Operation(summary = "책 대출")
    @PostMapping("/v1/books/loan")
    @Authenticated
    public ResponseEntity<HttpStatus> borrowBook(@Valid @RequestBody BorrowBookHttpRequest request,
                                                 @UserIdentifier Long userId) {
        loanService.borrowBook(request.getBookId(), userId);
        return ResponseEntity.ok().build();
    }
}
