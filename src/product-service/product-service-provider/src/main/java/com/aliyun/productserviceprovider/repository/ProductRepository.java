package com.aliyun.productserviceprovider.repository;

import com.aliyun.productserviceprovider.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author xiaofeng
 * @date 2021/3/1
 *
 * 提供Product表的增删改查接口
 *
 */
public interface ProductRepository extends JpaRepository<Product, String> {
    /**
     * 根据商品Name（唯一）查询商品
     * @param productName 商品名称
     * @return 查询结果
     */
    Optional<Product> findProductByName(String productName);

    /**
     * 根据商品类型获取商品
     * @param type 类型
     * @param pageable 分页对象，包含查询页数、每页数量
     * @return 查询结果
     */
    Page<Product> findProductsByType(Integer type, Pageable pageable);

}
