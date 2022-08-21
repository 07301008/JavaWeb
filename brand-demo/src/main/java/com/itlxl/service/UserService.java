package com.itlxl.service;

import com.itlxl.mapper.UserMapper;
import com.itlxl.pojo.User;
import com.itlxl.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        User select = mapper.select(user);
        // 释放资源
        sqlSession.close();
        return select;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    public boolean register(User user){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法，判断用户是否存在
        User select = mapper.selectByUsername(user.getUsername());
        if (select == null){
            // 用户不存在，可以注册
            mapper.add(user);
            // 提交事务
            sqlSession.commit();
        }
        // 释放资源
        sqlSession.close();
        return select == null; // 等于null返回true，不等于null返回false
    }
}
