package com.aliyun.userservice.service.api;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.userservice.domain.User;

/**
 * @author xiaofeng
 * @date 2021/02/23
 *
 * User用户表相关的增删改查操作接口
 */
public interface UserService {
    /**
     * 向user表中插入一个新的用户
     * @param newUser 新的需要添加的用户对象
     * @return 插入成功之后的用户对象
     */
    Response<User> addUser(User newUser);

    /**
     * 根据username查询用户
     * @param username 用户名
     * @return 查询到的用户对象
     */
    Response<User> getUserByName(String username);

    /**
     * 根据userId查询用户
     * @param userId 用户ID，用户表主键，UUID生成
     * @return 查询到的用户对象
     */
    Response<User> getUserById(String userId);
}
