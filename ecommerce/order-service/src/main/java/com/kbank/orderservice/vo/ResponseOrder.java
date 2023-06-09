package com.kbank.orderservice.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class ResponseOrder {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;

    private Date createdAt;
}
