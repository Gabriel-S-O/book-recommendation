package com.elotech.library_management.service;

import com.elotech.library_management.entity.Book;
import com.elotech.library_management.entity.Loan;
import com.elotech.library_management.entity.User;
import com.elotech.library_management.model.request.loan.CreateLoanRequest;
import com.elotech.library_management.model.request.loan.UpdateLoanRequest;
import com.elotech.library_management.repository.BookRepository;
import com.elotech.library_management.repository.LoanRepository;
import com.elotech.library_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    private final boolean LOANED = true;
    private final boolean RETURNED = false;

    public void create(CreateLoanRequest request){
        var user = getUserOrThrow(request.userId());
        var book = getBookOrThrow(request.bookId());
        validateLoan(user.getId(), book.getId());
        loanRepository.save(CreateLoanRequest.toEntity(request, user, book));
    }

    public void update(Integer id){
        var loan = getLoanOrThrow(id);
        loanRepository.save(updateLoan(loan));
    }

    private User getUserOrThrow(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private Book getBookOrThrow(Integer id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    private Loan getLoanOrThrow(Integer id) {
        return this.loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    private void validateLoan(Integer userId, Integer bookId){
        loanRepository.findByBookIdAndStatus(bookId, LOANED).ifPresent(alreadyLoaned -> {
            throw new RuntimeException(("Book already loaned"));
        });
    }

    private Loan updateLoan(Loan loan) {
        loan.setStatus(RETURNED);
        loan.setReturnedAt(LocalDateTime.now());
        return loan;
    }
}
