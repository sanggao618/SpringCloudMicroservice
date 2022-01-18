package com.atguigu.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sanggao
 * @create 2022-01-17 14:19
 */

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9002 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain9002.class,args);
    }

}
