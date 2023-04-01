package com.kbank.userservice.dao;

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

}