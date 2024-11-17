package com.e_commerce.ecommerce_app.repository;

import com.e_commerce.ecommerce_app.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    void deleteAllByCartId(Long id);
}
