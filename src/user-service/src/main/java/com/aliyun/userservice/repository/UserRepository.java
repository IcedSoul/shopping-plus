package com.aliyun.userservice.repository;

import com.aliyun.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author xiaofeng
 * @date 2021/02/23
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * 根据用户名username查询用户
     * @param username 用户名
     * @return 查询结果（可能为空）
     */
    Optional<User> findByUsername(String username);
}
