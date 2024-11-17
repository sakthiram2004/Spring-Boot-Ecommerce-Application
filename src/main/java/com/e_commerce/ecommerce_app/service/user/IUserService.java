package com.e_commerce.ecommerce_app.service.user;

import com.e_commerce.ecommerce_app.dto.UserDto;
import com.e_commerce.ecommerce_app.model.User;
import com.e_commerce.ecommerce_app.request.CreateUserRequest;
import com.e_commerce.ecommerce_app.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long uderId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request,Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);
}
