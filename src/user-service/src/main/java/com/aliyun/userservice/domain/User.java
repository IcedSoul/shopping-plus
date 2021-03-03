package com.aliyun.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author xiaofeng
 * @date 2021/02/23
 *
 * 用户表
 */

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(nullable = false)
    private String userId;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 30)
    private String email;

    @Column(length = 20)
    private String nickname;

    @Column(length = 20)
    private String password;

    @Column(length = 11)
    private String phoneNumber;

    private Timestamp birthday;

    public User(String username, String email, String nickname, String password, String phoneNumber, Timestamp birthday) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }
}
