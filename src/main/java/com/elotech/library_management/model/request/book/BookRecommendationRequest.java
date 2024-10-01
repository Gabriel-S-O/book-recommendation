package com.elotech.library_management.model.request.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRecommendationRequest(
        @NotNull(message = "userId is required") Integer userId,
        @NotBlank(message = "category is required") String category
) {
}
