package cn.icedsoul.loginservice.Domain;

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
public class User {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "int(11) comment '用户主键'")
    private int id;
    @Column(nullable = false, columnDefinition = "varchar(40) comment '用户姓名'")
    private String name;
    @Column(nullable = false, columnDefinition = "varchar(40) comment '用户密码'")
    private String password;
    @Column(columnDefinition = "varchar(40) comment '用户手机'")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(40) comment '用户主键'")
    private String email;
    @Column(columnDefinition = "varchar(40) comment '信息状态(备用)'")
    private String state;

}
