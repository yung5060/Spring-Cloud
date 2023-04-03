package com.kbank.catalogservice.service;

import java.util.List;

import com.kbank.catalogservice.entity.CatalogEntity;

public interface CatalogService {
    
    public List<CatalogEntity> getAllCatalogs();
}
