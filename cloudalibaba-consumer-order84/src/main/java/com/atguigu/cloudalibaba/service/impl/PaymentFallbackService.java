package com.atguigu.cloudalibaba.service.impl;

import com.atguigu.cloudalibaba.service.PaymentService;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author sanggao
 * @create 2022-01-18 14:48
 */

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {

        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial"));
    }
}