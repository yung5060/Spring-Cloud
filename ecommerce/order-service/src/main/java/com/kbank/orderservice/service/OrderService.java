package com.kbank.orderservice.service;

import com.kbank.orderservice.dto.OrderDto;
import com.kbank.orderservice.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    public OrderDto createOrder(OrderDto orderDto);
    public OrderDto getOrderByOrderId(String orderId);
    public List<OrderEntity> getOrdersByUserId(String userId);
}
