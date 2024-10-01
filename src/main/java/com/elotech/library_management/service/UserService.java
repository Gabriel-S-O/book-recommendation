package com.elotech.library_management.service;

import com.elotech.library_management.entity.User;
import com.elotech.library_management.model.request.user.CreateUserRequest;
import com.elotech.library_management.model.request.user.UpdateUserRequest;
import com.elotech.library_management.model.response.user.CreateUserResponse;
import com.elotech.library_management.model.response.user.GetUserResponse;
import com.elotech.library_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CreateUserResponse createUserResponse;
    private final GetUserResponse getUserResponse;

    public CreateUserResponse create(CreateUserRequest request) {
        return createUserResponse.toPresentation(userRepository.save(CreateUserRequest.toEntity(request)));
    }

    public void update(UpdateUserRequest request, Integer id) {
        var user = getUserOrThrow(id);
        BeanUtils.copyProperties(request, user);
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.delete(getUserOrThrow(id));
    }

    public GetUserResponse getById(Integer id) {
        return getUserResponse.toPresentation(getUserOrThrow(id));
    }

    public List<GetUserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(getUserResponse::toPresentation)
                .toList();
    }

    private User getUserOrThrow(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
