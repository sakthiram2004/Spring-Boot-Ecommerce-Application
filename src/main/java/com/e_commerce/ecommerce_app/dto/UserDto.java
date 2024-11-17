package com.e_commerce.ecommerce_app.dto;

import com.e_commerce.ecommerce_app.enums.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;
}