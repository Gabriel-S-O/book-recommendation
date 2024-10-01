package com.elotech.library_management.model.request.user;

import com.elotech.library_management.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CreateUserRequest(
        @NotBlank(message = "name is required") String name,
        @NotBlank(message = "email is required") @Email String email,
        @NotBlank(message = "phone is required") String phone
) {

    public static User toEntity(CreateUserRequest request) {
        final var user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
