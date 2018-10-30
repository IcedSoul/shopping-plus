package cn.icedsoul.loginservice.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class UserAddress {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    @Column(nullable = false, columnDefinition = "int(11) comment '主键、外键'")
    private int id;
    @Column(columnDefinition = "varchar(50) comment '用户地址'")
    private String address;
    @Column(columnDefinition = "varchar comment '邮政编码'")
    private String postNumber;
}
