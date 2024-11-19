package com.e_commerce.ecommerce_app.controller;

import com.e_commerce.ecommerce_app.dto.LoginRequest;
import com.e_commerce.ecommerce_app.dto.LoginResponse;
import com.e_commerce.ecommerce_app.dto.UserDto;
import com.e_commerce.ecommerce_app.exceptions.AlreadyExistsException;
import com.e_commerce.ecommerce_app.model.User;
import com.e_commerce.ecommerce_app.request.CreateUserRequest;
import com.e_commerce.ecommerce_app.response.ApiResponse;
import com.e_commerce.ecommerce_app.service.JwtUtils;
import com.e_commerce.ecommerce_app.service.OurUserDetailService;
import com.e_commerce.ecommerce_app.service.user.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final OurUserDetailService userDetailService;
    private final JwtUtils jwtUtils;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            User user = userService.createUser(request);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Create User Success!", userDto));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
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
