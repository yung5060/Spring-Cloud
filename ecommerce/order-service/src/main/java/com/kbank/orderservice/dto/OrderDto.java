package com.kbank.orderservice.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderDto {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    private Date createdAt;
}
