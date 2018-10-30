package cn.icedsoul.paymentservice.Service.Service;

import cn.icedsoul.paymentservice.Utils.Response;

public interface PaymentService {
    Response payForProduct(String orderId,Integer userId,String payWay);
}
