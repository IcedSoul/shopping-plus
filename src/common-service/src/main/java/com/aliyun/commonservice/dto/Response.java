package com.aliyun.commonservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xiaofeng
 * @date 2021/02/23
 */
@Data
@AllArgsConstructor
public class Response<T>{
    /**
     * 1: success
     * -1: fail
     * 0: unknown
     */
    private Integer status;
    private String msg;
    private T content;
}
