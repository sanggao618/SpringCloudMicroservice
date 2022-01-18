package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sanggao
 * @create 2022-01-11 11:30
 */

@Configuration //配置类
public class ApplicationContextConfig {

    @Bean //注册到spring容器中
    //@LoadBalanced //赋予RestTemplate负载均衡的能力（轮询）
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
