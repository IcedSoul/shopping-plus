package com.aliyun.userservice.controller;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.userservice.domain.User;
import com.aliyun.userservice.service.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * @author xiaofeng
 * @date 2021/02/23
 */
@RestController
@Api(value = "用户相关的Http接口")
@RequestMapping(value = "/v1")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation(value = "Add user", notes = "添加用户", response = Response.class)
    @PostMapping(value = "/user")
    public Response<User> addMessage(@RequestParam("username") String username, @RequestParam("email") String email,
                               @RequestParam("nickname") String nickname, @RequestParam("password") String password,
                               @RequestParam("phoneNumber") String phoneNumber, @RequestParam("birthday")Timestamp birthday) {
        return userService.addUser(new User(username, email, nickname, password, phoneNumber, birthday));
    }

    @ApiOperation(value = "Get user by username", notes = "根据用户名username获取用户", response = Response.class)
    @GetMapping(value = "/user/{username}")
    public Response<User> getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByName(username);
    }

    @ApiOperation(value = "Get user by userId", notes = "根据用户Id userId获取用户", response = Response.class)
    @GetMapping(value = "/user/{userId}")
    public Response<User> getUserByUserId(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

}
