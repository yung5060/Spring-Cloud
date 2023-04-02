package com.kbank.userservice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kbank.userservice.entity.UserEntity;
import com.kbank.userservice.util.MyBatisUtil;

@Repository
public class UserMapper {

    public void save(UserEntity userEntity) {
        SqlSession session = MyBatisUtil.getSqlSession();
        session.insert("save", userEntity);
        session.commit();
        session.close();
    }

    public List<UserEntity> findAll() {
        SqlSession session = MyBatisUtil.getSqlSession();
        List<UserEntity> result = session.selectList("findAll");
        session.commit();
        session.close();
        return result;
    }

    public UserEntity findByUserId(String userId) {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserEntity userEntity = session.selectOne("findByUserId", userId);
        session.commit();
        session.close();
        return userEntity;
    }
}