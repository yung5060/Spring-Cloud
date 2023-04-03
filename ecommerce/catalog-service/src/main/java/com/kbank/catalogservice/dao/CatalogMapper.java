package com.kbank.catalogservice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kbank.catalogservice.entity.CatalogEntity;
import com.kbank.catalogservice.util.MyBatisUtil;

@Repository
public class CatalogMapper {
    
    public List<CatalogEntity> findAll() {
        SqlSession session = MyBatisUtil.getSqlSession();
        List<CatalogEntity> result = session.selectList("findAll");
        session.commit();
        session.close();
        return result;
    }

    public CatalogEntity findByProductId(String productId) {
        SqlSession session = MyBatisUtil.getSqlSession();
        CatalogEntity result = session.selectOne("findByProductId", productId);
        session.commit();
        session.close();
        return result;
    }
}
