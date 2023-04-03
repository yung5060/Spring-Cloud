package com.kbank.catalogservice.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class CatalogEntity {
    
    private Long id;
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;

    private Date createdAt;
}
