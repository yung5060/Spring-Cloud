package com.kbank.orderservice.dao;

import com.kbank.orderservice.entity.OrderEntity;
import com.kbank.orderservice.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderMapper {

    public List<OrderEntity> findByUserId(String userId) {
        SqlSession session = MyBatisUtil.getSqlSession();
        List<OrderEntity> result = session.selectList("findByUserId", userId);
        session.commit();
        session.close();
        return result;
    }

    public OrderEntity findByProductId(String orderId) {
        SqlSession session = MyBatisUtil.getSqlSession();
        OrderEntity result = session.selectOne("findByOrderId", orderId);
        session.commit();
        session.close();
        return result;
    }
}
