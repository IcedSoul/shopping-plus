package com.aliyun.fileservice.controller;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.fileservice.service.api.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaofeng
 * @date 2021/3/4
 */
@RestController
@Api(value = "商品相关的Http接口")
@RequestMapping(value = "/v1")
public class FileController {
    @Resource
    ImageService imageService;

    @ApiOperation(value = "Upload image", notes = "上传图片（特殊权限）", response = Response.class)
    @PostMapping(value = "/image")
    public Response<String> uploadImage(@RequestParam("image") MultipartFile image, HttpServletRequest request){
        return imageService.uploadImage(image, request);
    }
}
