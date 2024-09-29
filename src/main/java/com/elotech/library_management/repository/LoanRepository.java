package com.elotech.library_management.repository;

import com.elotech.library_management.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
