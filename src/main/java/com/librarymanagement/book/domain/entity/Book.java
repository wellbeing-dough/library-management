package com.librarymanagement.book.domain.entity;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import com.librarymanagement.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Where(clause = "deleted_at IS NULL")
@Table(name = "book")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String publisher;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    private LocalDateTime deletedAt;

    private LocalDateTime publishedAt;

    public void updateInfo(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public void mockDelete(LocalDateTime now) {
        this.deletedAt = now;
    }

    public void updateLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
