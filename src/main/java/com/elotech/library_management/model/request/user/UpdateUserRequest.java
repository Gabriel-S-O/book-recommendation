package com.elotech.library_management.model.request.user;

import com.elotech.library_management.entity.User;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

public record UpdateUserRequest(
        String name,
        @Email String email,
        String phone
) {

    public static User toEntity(UpdateUserRequest request) {
        final var user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
