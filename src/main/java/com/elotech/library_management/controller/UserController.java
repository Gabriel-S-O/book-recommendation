package com.elotech.library_management.controller;

import com.elotech.library_management.model.request.user.CreateUserRequest;
import com.elotech.library_management.model.request.user.UpdateUserRequest;
import com.elotech.library_management.model.response.user.CreateUserResponse;
import com.elotech.library_management.model.response.user.GetUserResponse;
import com.elotech.library_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetUserResponse> getAll() {
        return userService.getById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse create(@Valid @RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody UpdateUserRequest request) {
        userService.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

}
