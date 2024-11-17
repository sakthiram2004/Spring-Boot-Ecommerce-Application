package com.e_commerce.ecommerce_app.service.order;

import com.e_commerce.ecommerce_app.dto.OrderDto;
import com.e_commerce.ecommerce_app.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
