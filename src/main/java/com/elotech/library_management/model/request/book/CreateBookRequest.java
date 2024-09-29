package com.elotech.library_management.model.request.book;

import com.elotech.library_management.entity.Book;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CreateBookRequest(
        @NotBlank(message = "title is required") String title,
        @NotBlank(message = "author is required") String author,
        @NotBlank(message = "isbn is required") String isbn,
        @NotBlank(message = "category is required") String category,
        @NotBlank(message = "publishedAt is required") LocalDateTime publishedAt
) {

    public static Book toEntity(CreateBookRequest request) {
        final var book = new Book();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        book.setCategory(request.category());
        book.setPublishedAt(request.publishedAt());
        return book;
    }
}
