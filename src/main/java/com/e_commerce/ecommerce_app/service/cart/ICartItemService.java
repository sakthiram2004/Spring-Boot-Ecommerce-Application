package com.e_commerce.ecommerce_app.service.cart;

import com.e_commerce.ecommerce_app.model.CartItem;
import com.e_commerce.ecommerce_app.model.Product;

public interface ICartItemService {
    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long productId, int quantity);

    CartItem getCartItem(Long cartId, Long productId);
}