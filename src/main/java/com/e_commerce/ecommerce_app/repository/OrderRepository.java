package com.e_commerce.ecommerce_app.repository;

import com.e_commerce.ecommerce_app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUserId(Long userId);
}
