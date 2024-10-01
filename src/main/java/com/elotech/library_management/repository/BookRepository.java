package com.elotech.library_management.repository;

import com.elotech.library_management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b LEFT JOIN Loan l ON b.id = l.book.id AND l.user.id = :userId " +
            "WHERE b.category = :category AND l.book.id IS NULL AND b.deletedAt IS NULL")
    List<Book> findBooksNotLoanedByUserInCategory(@Param("userId") Integer userId,
                                                  @Param("category") String category);
}
