package com.e_commerce.ecommerce_app.service.cart;

import com.e_commerce.ecommerce_app.model.Cart;
import com.e_commerce.ecommerce_app.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
