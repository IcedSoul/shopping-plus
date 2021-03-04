package com.aliyun.fileservice.service.api;

import com.aliyun.commonservice.dto.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xiaofeng
 * @date 2021/3/4
 */
public interface ImageService {
    /**
     * 上传图片
     * @param image 图片文件流
     * @param request 用于获取文件存储地址
     * @return 图片名称
     */
    Response<String> uploadImage(MultipartFile image, HttpServletRequest request);


}
