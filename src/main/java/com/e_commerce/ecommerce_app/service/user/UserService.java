package com.e_commerce.ecommerce_app.service.user;

import com.e_commerce.ecommerce_app.dto.UserDto;
import com.e_commerce.ecommerce_app.enums.UserRole;
import com.e_commerce.ecommerce_app.exceptions.AlreadyExistsException;
import com.e_commerce.ecommerce_app.exceptions.ResourceNotFoundException;
import com.e_commerce.ecommerce_app.model.User;
import com.e_commerce.ecommerce_app.repository.UserRepository;
import com.e_commerce.ecommerce_app.request.CreateUserRequest;
import com.e_commerce.ecommerce_app.request.UserUpdateRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

    }

    @Override
    public User createUser(CreateUserRequest request) {
        return  Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setEmail(request.getEmail());
                    user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    user.setRole(UserRole.USER);
                    return  userRepository.save(user);
                }) .orElseThrow(() -> new AlreadyExistsException("Oops!" +request.getEmail() +" already exists!"));

    }

    @Override
    public User updateUser(UserUpdateRequest request,Long userId) {
        return  userRepository.findById(userId).map(existingUser ->{
            existingUser.setFirstName(request.getFirstName());
            existingUser.setLastName(request.getLastName());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository :: delete, () ->{
            throw new ResourceNotFoundException("User not found!");
        });
    }

    @Override
    public UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @PostConstruct
    public void createAdmin(){
        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setRole(UserRole.ADMIN);
        user.setEmail("admin@gmail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("12345"));
        userRepository.save(user);
    }
}
