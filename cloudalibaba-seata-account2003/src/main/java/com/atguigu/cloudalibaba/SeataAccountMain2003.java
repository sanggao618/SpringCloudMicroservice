package com.atguigu.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sanggao
 * @create 2022-01-18 17:43
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源的自动装配，改用自定义数据源
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMain2003 {

    public static void main(String[] args) {

        SpringApplication.run(SeataAccountMain2003.class, args);
    }
}

