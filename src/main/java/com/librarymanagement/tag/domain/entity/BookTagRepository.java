package com.librarymanagement.tag.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTagRepository extends JpaRepository<BookTag, Long> {
    boolean existsByTagIdAndBookId(Long tagId, Long bookId);
}
