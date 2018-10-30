package cn.icedsoul.paymentservice.Service.ServiceImpl;

import cn.icedsoul.paymentservice.Service.Service.PaymentService;
import cn.icedsoul.paymentservice.Utils.Response;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Response payForProduct(String orderId, Integer userId, String payWay) {

        return new Response(1,"支付成功",null);
    }
}
