package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author sanggao
 * @create 2022-01-13 15:07
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulMain9527 {

    public static void main(String[] args) {

        SpringApplication.run(ZuulMain9527.class,args);
    }
}
