package com.elotech.library_management.model.response.user;

import com.elotech.library_management.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserResponse {
    public Integer id;
    public String name;
    public String email;
    public String phone;
    public String createdAt;

    @Autowired
    private ModelMapper modelMapper;

    public GetUserResponse toPresentation(User user) {
        return modelMapper.map(user, GetUserResponse.class);
    }

}