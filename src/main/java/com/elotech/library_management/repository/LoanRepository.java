package com.elotech.library_management.repository;

import com.elotech.library_management.entity.Book;
import com.elotech.library_management.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Optional<Loan> findByBookIdAndStatus(Integer bookId,
                                         boolean status);
}
