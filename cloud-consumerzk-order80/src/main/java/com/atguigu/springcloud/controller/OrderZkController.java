package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sanggao
 * @create 2022-01-12 10:49
 */

@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/payment/zk")
    public String PaymentInfo() {

        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        System.out.println("消费者调用支付服务(zookeeper)--->result:" + result);
        return result;
    }

}
