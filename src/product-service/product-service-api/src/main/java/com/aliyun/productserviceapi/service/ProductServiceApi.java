package com.aliyun.productserviceapi.service;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.productserviceapi.dto.ProductDto;

/**
 * @author xiaofeng
 * @date 2021/3/2
 *
 * 商品表相关的Rpc操作接口
 *
 */
public interface ProductServiceApi {


//    Response<ProductDto> addProduct(ProductDto newProduct);

    /**
     * 根据商品ID获取商品信息
     * @param productId 商品ID
     * @return 商品对象
     */
    Response<ProductDto> getProductById(String productId);

    /**
     * 根据商品名称获取商品信息
     * @param productName 商品名称
     * @return 商品对象
     */
    Response<ProductDto> getProductByName(String productName);

}
