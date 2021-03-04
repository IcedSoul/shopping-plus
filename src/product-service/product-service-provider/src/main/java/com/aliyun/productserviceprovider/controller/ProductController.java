package com.aliyun.productserviceprovider.controller;

import com.aliyun.commonservice.dto.Response;
import com.aliyun.productserviceapi.dto.ProductDto;
import com.aliyun.productserviceprovider.domain.Product;
import com.aliyun.productserviceprovider.service.api.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaofeng
 * @date 2021/3/1
 */
@RestController
@Api(value = "商品相关的Http接口")
@RequestMapping(value = "/v1")
public class ProductController {

    @Resource
    ProductService productService;

    /**
     * 此接口属于特殊权限，需要进行特别的权限校验。
     * @param name 商品名称
     * @param description 商品介绍
     * @param tags 商品标签
     * @param price 价格
     * @param type 类型
     * @return 添加结果
     */
    @ApiOperation(value = "Add product", notes = "添加商品（特殊权限）", response = Response.class)
    @PostMapping(value = "/product")
    public Response<ProductDto> addProduct(@RequestParam("name") String name, @RequestParam("description") String description,
                               @RequestParam("tags") String tags, @RequestParam("price") Double price,
                               @RequestParam("type") Integer type, @RequestParam("img") String img){
        return productService.addProduct(new ProductDto(name, description, tags, price, type, img));
    }

    @ApiOperation(value = "Get product by productId", notes = "根据商品ID获取商品", response = Response.class)
    @GetMapping(value = "/product/{productId}")
    public Response<ProductDto> getProductById(@PathVariable("productId") String productId){
        return productService.getProductById(productId);
    }

    @ApiOperation(value = "Get product by product name", notes = "根据商品名称获取商品", response = Response.class)
    @GetMapping(value = "/product/{name}")
    public Response<ProductDto> getProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }

    @ApiOperation(value = "Get products by product type", notes = "根据商品类型获取商品", response = Response.class)
    @GetMapping(value = "/product/{type}/{page}/{number}")
    public Response<List<ProductDto>> getProductByType(@PathVariable("type") Integer type, @PathVariable("page") Integer page,
                                                    @PathVariable("number") Integer number){
        return productService.getProductsByType(type, page, number);
    }

    @ApiOperation(value = "Get product by productId", notes = "根据商品ID获取商品", response = Response.class)
    @GetMapping(value = "/product/{page}/{number}")
    public Response<List<ProductDto>> getAllProducts(@PathVariable("page") Integer page, @PathVariable("number") Integer number){
        return productService.getAllProducts(page, number);
    }
}
