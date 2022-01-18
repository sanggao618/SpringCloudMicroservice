package com.atguigu.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sanggao
 * @create 2022-01-17 14:43
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3377.class, args);
    }
}
