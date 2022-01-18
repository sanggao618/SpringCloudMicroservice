package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author sanggao
 * @create 2022-01-13 11:08
 */

@Component //注册服务降级类
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK falls back...";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut falls back...";
    }
}
