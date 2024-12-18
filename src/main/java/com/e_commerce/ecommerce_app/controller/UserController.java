package com.e_commerce.ecommerce_app.controller;
import com.e_commerce.ecommerce_app.dto.LoginRequest;
import com.e_commerce.ecommerce_app.dto.LoginResponse;
import com.e_commerce.ecommerce_app.dto.UserDto;
import com.e_commerce.ecommerce_app.exceptions.AlreadyExistsException;
import com.e_commerce.ecommerce_app.exceptions.ResourceNotFoundException;
import com.e_commerce.ecommerce_app.model.User;
import com.e_commerce.ecommerce_app.request.CreateUserRequest;
import com.e_commerce.ecommerce_app.request.UserUpdateRequest;
import com.e_commerce.ecommerce_app.response.ApiResponse;
import com.e_commerce.ecommerce_app.service.JwtUtils;
import com.e_commerce.ecommerce_app.service.OurUserDetailService;
import com.e_commerce.ecommerce_app.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final IUserService userService;
    private final AuthenticationManager authenticationManager;
    private final OurUserDetailService userDetailService;
    private final JwtUtils jwtUtils;

    @GetMapping("/{userId}/user")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId) {
        try {
            System.out.println(userId);
            User user = userService.getUserById(userId);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Success", userDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            User user = userService.createUser(request);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Create User Success!", userDto));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
    @PutMapping("/{userId}/update")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserUpdateRequest request, @PathVariable Long userId) {
        try {
            User user = userService.updateUser(request, userId);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Update User Success!", userDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }


    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            final UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getEmail());
            final String jwt = jwtUtils.generateToken(userDetails);

            return ResponseEntity.ok(new LoginResponse(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}