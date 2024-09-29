package com.elotech.library_management.repository;

import com.elotech.library_management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
