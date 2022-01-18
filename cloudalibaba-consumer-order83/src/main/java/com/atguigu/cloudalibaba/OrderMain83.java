package com.atguigu.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sanggao
 * @create 2022-01-17 13:14
 */

@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain83 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain83.class,args);
    }
}
