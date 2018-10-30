package cn.icedsoul.paymentservice.Domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PayRecord {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "int(11) comment '订单外键'")
    private int orderId;
    @Column(nullable = false, columnDefinition = "int(11) comment '用户外键'")
    private int userId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime comment '支付时间'")
    private Timestamp payTime;
    @Column(nullable = false, columnDefinition = "double(11) comment '支付金额'")
    private Double payNumber;
    @Column(columnDefinition = "varchar(50) comment '支付方式'")
    private String payWay;
}
