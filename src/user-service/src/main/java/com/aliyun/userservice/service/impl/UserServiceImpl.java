package com.aliyun.userservice.service.impl;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.userservice.domain.User;
import com.aliyun.userservice.repository.UserRepository;
import com.aliyun.userservice.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author xiaofeng
 * @date 2021/02/23
 *
 * 用户表user的增删改查实现
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    /**
     * 向user表中插入一个新的用户
     *
     * @param newUser 新的需要添加的用户对象
     * @return 插入成功之后的用户对象
     */
    @Override
    public Response<User> addUser(User newUser) {
        try {
            User user = userRepository.save(newUser);
            return new Response<>(1, "insert user success", user);
        }catch (Exception e){
            log.info("Insert User: " + e.getMessage());
            return new Response<>(-1, "insert user fail", null);
        }
    }

    /**
     * 根据username查询用户
     *
     * @param username 用户名
     * @return 查询到的用户对象
     */
    @Override
    public Response<User> getUserByName(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.map(
                user -> new Response<>(1, "find user success", user)
        ).orElseGet(
                () -> new Response<>(-1, "cannot find user", null)
        );
    }

    /**
     * 根据userId查询用户
     *
     * @param userId 用户ID，用户表主键，UUID生成
     * @return 查询到的用户对象
     */
    @Override
    public Response<User> getUserById(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(
                user -> new Response<>(1, "find user success", user)
        ).orElseGet(
                () -> new Response<>(-1, "can not find user", null)
        );
    }
}
