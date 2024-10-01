package com.elotech.library_management.model.request.book;

import com.elotech.library_management.entity.Book;

import java.time.LocalDateTime;

public record UpdateBookRequest(
        String title,
        String author,
        String isbn,
        String category,
        LocalDateTime publishedAt
) {

    public static Book toEntity(UpdateBookRequest request, Integer id) {
        final var book = new Book();
        book.setId(id);
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        book.setCategory(request.category());
        book.setPublishedAt(request.publishedAt());
        return book;
    }
}
