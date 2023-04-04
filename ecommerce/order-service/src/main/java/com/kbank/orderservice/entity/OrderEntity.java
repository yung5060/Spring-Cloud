package com.kbank.orderservice.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class OrderEntity {

    private Long id;
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String userId;

    private String orderId;

    private Date createdAt;
}
