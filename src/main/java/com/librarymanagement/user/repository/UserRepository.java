package com.librarymanagement.user.repository;

import com.librarymanagement.user.domian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
