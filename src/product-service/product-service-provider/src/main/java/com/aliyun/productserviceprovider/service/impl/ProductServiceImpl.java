package com.aliyun.productserviceprovider.service.impl;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.productserviceapi.dto.ProductDto;
import com.aliyun.productserviceapi.service.ProductServiceApi;
import com.aliyun.productserviceprovider.domain.Product;
import com.aliyun.productserviceprovider.repository.ProductRepository;
import com.aliyun.productserviceprovider.service.api.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xiaofeng
 * @date 2021/3/1
 */
@Slf4j
@DubboService(version = "0.0.1")
public class ProductServiceImpl implements ProductService, ProductServiceApi {

    @Resource
    ProductRepository productRepository;

    /**
     * 新增商品
     *
     * @param newProduct 商品实例
     * @return 添加商品结果，成功返回插入之后的对象实例
     */
    @Override
    public Response<ProductDto> addProduct(ProductDto newProduct) {
        try {
            Product product = productRepository.save(new Product(newProduct));
            return new Response<>(1, "insert product success", product.toDto());
        }catch (Exception e){
            log.info("Insert product: " + e.getMessage());
            return new Response<>(-1, "insert product fail", null);
        }
    }

    /**
     * 根据商品ID查询商品
     *
     * @param productId 商品ID
     * @return 查询结果
     */
    @Override
    public Response<ProductDto> getProductById(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(
                product -> new Response<>(1, "find product success", product.toDto())
        ).orElseGet(
                () -> new Response<>(-1, "cannot find product", null)
        );
    }

    /**
     * 根据商品名称查询商品
     *
     * @param productName 商品名称
     * @return 查询结果
     */
    @Override
    public Response<ProductDto> getProductByName(String productName) {
        Optional<Product> productOptional = productRepository.findProductByName(productName);
        return productOptional.map(
                product -> new Response<>(1, "find product success", product.toDto())
        ).orElseGet(
                () -> new Response<>(-1, "cannot find product", null)
        );
    }

    /**
     * 查询某个类型的商品
     *
     * @param type   商品类型
     * @param page   查询页数
     * @param number 每页查询数量
     * @return 查询结果
     */
    @Override
    public Response<List<ProductDto>> getProductsByType(Integer type, Integer page, Integer number) {
        try {
            Pageable pageable = PageRequest.of(page, number);
            Page<Product> products = productRepository.findProductsByType(type, pageable);
            return new Response<>(1, "find products by type error",
                    products.getContent().stream().map(Product::toDto).collect(Collectors.toList()));
        } catch (Exception e){
            log.info("Get products by type error" + e.getMessage());
            return new Response<>(-1, "find products by type error", null);
        }
    }

    /**
     * 查询所有商品
     *
     * @param page   查询页数
     * @param number 每页查询数量
     * @return 查询结果
     */
    @Override
    public Response<List<ProductDto>> getAllProducts(Integer page, Integer number) {
        try {
            Pageable pageable = PageRequest.of(page, number);
            Page<Product> products = productRepository.findAll(pageable);
            return new Response<>(1, "find all products",
                    products.getContent().stream().map(Product::toDto).collect(Collectors.toList()));
        } catch (Exception e){
            log.info("Get all products: " + e.getMessage());
            return new Response<>(-1, "find all products fail", null);
        }
    }
}
