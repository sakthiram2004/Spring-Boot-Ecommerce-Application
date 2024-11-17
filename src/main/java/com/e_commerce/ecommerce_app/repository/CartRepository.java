package com.e_commerce.ecommerce_app.repository;

import com.e_commerce.ecommerce_app.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUserId(Long userId);
}
