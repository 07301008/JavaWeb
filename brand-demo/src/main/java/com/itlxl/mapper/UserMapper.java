package com.itlxl.mapper;

import com.itlxl.pojo.User;

public interface UserMapper {

    /**
     * 根据用户名和密码来查询用户对象
     * @param user
     * @return
     */
    User select(User user);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);
}
