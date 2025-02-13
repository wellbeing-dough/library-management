package com.librarymanagement.book.repository;

import com.librarymanagement.book.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
