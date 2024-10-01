package com.elotech.library_management.model.request.loan;

import com.elotech.library_management.entity.Book;
import com.elotech.library_management.entity.Loan;
import com.elotech.library_management.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateLoanRequest(
        @NotNull(message = "userId is required") Integer userId,
        @NotNull(message = "bookId is required") Integer bookId
) {

    public static Loan toEntity(CreateLoanRequest request,
                                User user,
                                Book book) {
        final var loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanedAt(LocalDateTime.now());
        loan.setStatus(false);
        return loan;
    }
}
