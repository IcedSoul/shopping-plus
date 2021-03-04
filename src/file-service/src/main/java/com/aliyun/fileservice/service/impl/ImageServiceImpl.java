package com.aliyun.fileservice.service.impl;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.fileservice.service.api.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.UUID;

/**
 * @author xiaofeng
 * @date 2021/3/4
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    /**
     * 上传图片
     *
     * @param image   图片文件流
     * @param request 用于获取文件存储地址
     * @return 图片名称
     */
    @Override
    public Response<String> uploadImage(MultipartFile image, HttpServletRequest request) {
        try{
            if(image != null && !image.isEmpty()) {
                String fileRealPath = request.getSession().getServletContext().getRealPath("/static/img");
                File fileFolder = new File(fileRealPath);
                String fileName = UUID.randomUUID().toString() + "." + image.getContentType();
                File file = new File(fileFolder,fileName);
                image.transferTo(file);
                log.info(fileName, "has saved to", fileFolder.getAbsolutePath());
                return new Response<>(1, "save image success", fileName);
            }
            return new Response<>(-1, "file does not exist!", null);
        } catch(Exception e){
            e.printStackTrace();
            return new Response<>(-1, "save image error", null);
        }
    }
}
