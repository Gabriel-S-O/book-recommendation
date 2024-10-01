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

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetUserResponse> getAll() {
        return userService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse create(@Valid @RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody UpdateUserRequest request, @PathVariable Integer id) {
        userService.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

}
