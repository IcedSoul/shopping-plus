package com.aliyun.authserviceprovider.util;

/**
 * @author xiaofeng
 * @date 2021/3/5
 */
public class RedisUtils {
    public static String getKey(String... key){
        return String.join(":", key);
    }
}
