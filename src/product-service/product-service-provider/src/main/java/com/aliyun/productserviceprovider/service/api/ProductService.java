package com.aliyun.productserviceprovider.service.api;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.productserviceapi.dto.ProductDto;

import java.util.List;


/**
 * @author xiaofeng
 * @date 2021/3/1
 *
 * 商品表相关的Http增删改查接口
 *
 */
public interface ProductService {
    /**
     * 新增商品
     * @param newProduct 商品实例
     * @return 添加商品结果，成功返回插入之后的对象实例
     */
    Response<ProductDto> addProduct(ProductDto newProduct);

    /**
     * 根据商品ID查询商品
     * @param productId 商品ID
     * @return 查询结果
     */
    Response<ProductDto> getProductById(String productId);

    /**
     * 根据商品名称查询商品
     * @param productName 商品名称
     * @return 查询结果
     */
    Response<ProductDto> getProductByName(String productName);

    /**
     * 查询某个类型的商品
     * @param type 商品类型
     * @param page 查询页数
     * @param number 每页查询数量
     * @return 查询结果
     */
    Response<List<ProductDto>> getProductsByType(Integer type, Integer page, Integer number);

    /**
     *查询所有商品
     * @param page 查询页数
     * @param number 每页查询数量
     * @return 查询结果
     */
    Response<List<ProductDto>> getAllProducts(Integer page, Integer number);
}
