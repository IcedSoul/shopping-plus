package com.aliyun.authserviceprovider.service.impl;

import com.aliyun.authserviceprovider.service.api.MyUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author xiaofeng
 * @date 2021/3/5
 */
@Slf4j
public class MyUserDetailServiceImpl implements MyUserDetailService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if
        return null;
    }
}
