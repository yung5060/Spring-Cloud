package com.kbank.catalogservice.service;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.kbank.catalogservice.dao.CatalogMapper;
import com.kbank.catalogservice.entity.CatalogEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogMapper catalogMapper;
    private final Environment env;

    @Override
    public List<CatalogEntity> getAllCatalogs() {
        log.info(String.format("port %s is finding all catalogs", env.getProperty("local.server.port")));
        return catalogMapper.findAll();
    }

    
}
