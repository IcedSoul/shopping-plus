package cn.icedsoul.productsservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "int(11) comment '商品主键'")
    private int id;
    @Column(nullable = false, columnDefinition = "varchar(40) comment '商品名称'")
    private String name;
    @Column(columnDefinition = "varchar(500) comment '商品描述'")
    private String description;
    @Column(columnDefinition = "varchar(500) comment '商品关键词'")
    private String keyWord;
    @Column(nullable = false, columnDefinition = "double(11) comment '商品价格'")
    private Double price;
    @Column(nullable = false, columnDefinition = "int(11) comment '商品库存'")
    private Integer counts;
    @Column(nullable = false, columnDefinition = "int(11) comment '商品类型'")
    private Integer type;
    @Column(columnDefinition = "int(11) comment '卖家主键'")
    private Integer seller;

    public Products(String name,String description,String keyWord,Double price,Integer counts,Integer type,Integer seller){
        this.name = name;
        this.description = description;
        this.keyWord = keyWord;
        this.price = price;
        this.counts = counts;
        this.type = type;
        this.seller = seller;
    }
}
