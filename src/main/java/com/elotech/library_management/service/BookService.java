package com.elotech.library_management.service;

import com.elotech.library_management.common.configs.BeanUtilsConfig;
import com.elotech.library_management.entity.Book;
import com.elotech.library_management.model.request.book.BookRecommendationRequest;
import com.elotech.library_management.model.request.book.CreateBookRequest;
import com.elotech.library_management.model.request.book.UpdateBookRequest;
import com.elotech.library_management.model.response.book.BookRecommendationResponse;
import com.elotech.library_management.model.response.book.CreateBookResponse;
import com.elotech.library_management.model.response.book.GetBookResponse;
import com.elotech.library_management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final CreateBookResponse createBookResponse;
    private final GetBookResponse getBookResponse;
    private final BookRecommendationResponse bookRecommendationResponse;

    public CreateBookResponse create(CreateBookRequest request) {
        return createBookResponse.toPresentation(bookRepository.save(CreateBookRequest.toEntity(request)));
    }

    public void update(UpdateBookRequest request, Integer id) {
        var book = getBookOrThrow(id);
        BeanUtilsConfig.copyNonNullProperties(request, book);
        bookRepository.save(book);
    }

    public void delete(Integer id) {
        bookRepository.delete(getBookOrThrow(id));
    }

    public GetBookResponse getById(Integer id) {
        return getBookResponse.toPresentation(getBookOrThrow(id));
    }

    public List<GetBookResponse> getAll() {
        return bookRepository.findAll().stream()
                .map(getBookResponse::toPresentation)
                .toList();
    }

    public List<BookRecommendationResponse> getRecommendation(BookRecommendationRequest request) {
        var books = bookRepository.findBooksNotLoanedByUserInCategory(request.userId(), request.category());
        return books.stream()
                .map(bookRecommendationResponse::toPresentation)
                .toList();
    }

    private Book getBookOrThrow(Integer id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
