package com.librarymanagement.book.ui.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class updateBookHttpRequest {

    @Schema(description = "수정할 책 id", example = "1")
    @NotNull(message = "책 id는 필수 입니다")
    private Long bookId;

    @Schema(description = "등록할 책 제목", example = "그릿")
    @NotBlank(message = "책 제목은 필수 입니다")
    @Size(min = 1, max = 100, message = "책 제목은 1자 이상 100자 이하로 입력해주세요")
    private String title;

    @Schema(description = "저자", example = "홍길동")
    @NotBlank(message = "저자 이름은 필수 입니다")
    @Size(min = 1, max = 50, message = "저자 이름은 1자 이상 50자 이하로 입력해주세요")
    private String author;

    @Schema(description = "출판사", example = "동우 북스")
    @NotBlank(message = "출판사 이름은 필수 입니다")
    @Size(min = 1, max = 50, message = "출판사 이름은 1자 이상 50자 이하로 입력해주세요")
    private String publisher;
}
