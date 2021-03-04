package com.aliyun.productserviceprovider.domain;

import com.aliyun.productserviceapi.dto.ProductDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author xiaofeng
 * @date 2021/3/1
 *
 * 商品表
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(nullable = false, length = 15)
    private String productId;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(length = 300)
    private String description;

    @Column(length = 300)
    private String tags;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private String img;


    public Product(String name, String description, String tags, Double price, Integer type, String img) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.price = price;
        this.type = type;
        this.img = img;
    }

    public Product(ProductDto productDto){
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.tags = productDto.getTags();
        this.price = productDto.getPrice();
        this.type = productDto.getType();
        this.img = productDto.getImg();
    }

    public ProductDto toDto(){
        return new ProductDto(this.productId, this.name, this.description,
                this.tags, this.price, this.type, this.img);
    }
}
