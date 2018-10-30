package cn.icedsoul.paymentservice.Controller;

import cn.icedsoul.paymentservice.Service.Service.PaymentService;
import cn.icedsoul.paymentservice.Utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "支付管理类",description = "负责调用支付接口，记录支付记录等")
@RequestMapping(value = "/")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @ApiOperation(value = "",notes = "用来新增一个商品",response = Response.class)
    @PostMapping(value = "/addProduct")
    public Response payForOrder(@RequestParam("orderId")String orderId, @RequestParam("userId")Integer userId,
                               @RequestParam("payWay")String payWay){
        return paymentService.payForProduct(orderId,userId,payWay);
    }


}
