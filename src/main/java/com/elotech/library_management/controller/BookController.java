package com.elotech.library_management.controller;

import com.elotech.library_management.model.request.book.BookRecommendationRequest;
import com.elotech.library_management.model.request.book.CreateBookRequest;
import com.elotech.library_management.model.request.book.UpdateBookRequest;
import com.elotech.library_management.model.response.book.BookRecommendationResponse;
import com.elotech.library_management.model.response.book.CreateBookResponse;
import com.elotech.library_management.model.response.book.GetBookResponse;
import com.elotech.library_management.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetBookResponse> getAll() {
        return bookService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBookResponse create(@Valid @RequestBody CreateBookRequest request) {
        return bookService.create(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBookResponse getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody UpdateBookRequest request, @PathVariable Integer id) {
        bookService.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }

    @GetMapping("/recommend")
    @ResponseStatus(HttpStatus.OK)
    public List<BookRecommendationResponse> getRecomendation(@Valid @RequestBody BookRecommendationRequest request){
        return bookService.getRecommendation(request);
    }

}

