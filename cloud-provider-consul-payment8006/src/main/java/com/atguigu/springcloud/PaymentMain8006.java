package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sanggao
 * @create 2022-01-12 12:51
 */

@SpringBootApplication
@EnableDiscoveryClient //向consul或zookeeper中注册服务
public class PaymentMain8006 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8006.class, args);
    }
}
