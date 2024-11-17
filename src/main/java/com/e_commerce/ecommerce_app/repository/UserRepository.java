package com.e_commerce.ecommerce_app.repository;

import com.e_commerce.ecommerce_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    UserDetails findByEmail(String username);
}
