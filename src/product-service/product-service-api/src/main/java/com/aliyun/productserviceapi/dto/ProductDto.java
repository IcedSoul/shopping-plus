package com.aliyun.productserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaofeng
 * @date 2021/3/2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String productId;
    private String name;
    private String description;
    private String tags;
    private Double price;
    private Integer type;

    public ProductDto(String name, String description, String tags, Double price, Integer type) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.price = price;
        this.type = type;
    }
}
