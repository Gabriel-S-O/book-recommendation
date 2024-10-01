package com.elotech.library_management.model.response.book;

import com.elotech.library_management.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRecommendationResponse {
    public Integer id;
    public String title;
    public String author;
    public String isbn;
    public String category;
    public String publishedAt;

    @Autowired
    private ModelMapper modelMapper;

    public BookRecommendationResponse toPresentation(Book book) {
        return modelMapper.map(book, BookRecommendationResponse.class);
    }
}
