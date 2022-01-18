package com.atguigu.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloudalibaba.service.PaymentService;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sanggao
 * @create 2022-01-18 14:14
 */

@RestController
@Slf4j
public class BreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    //OpenFeign
    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
            //exceptionsToIgnore = {IllegalArgumentException.class}) //忽略某类异常
    // fallback只负责业务异常，blockHandler只负责在sentinel控制台中配置的降级限流
    public CommonResult<Payment> fallback(@PathVariable Long id) {

        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id, CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {

        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"handlerFallback异常,exception内容:"+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {

        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,blockException内容:"+blockException.getMessage(),payment);
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {

        if(id == 4) {
            throw new RuntimeException("没有该id");
        }
        return paymentService.paymentSQL(id);
    }

}
